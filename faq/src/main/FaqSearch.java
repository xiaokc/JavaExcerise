package main;

import dao.DB;
import model.QAObj;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xkc on 11/4/15.
 */
public class FaqSearch {
    public static void main(String[] args) throws Exception {

//        searchAnsBySql();

        searchAnsByLucene();

    }

    /**
     * 通过sql语句进行查询
     */
    private static void searchAnsBySql() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String que = scanner.nextLine();
            String ans = DB.searchAnsByQue(que);
            if (ans != null) {
                System.out.println(ans);
            } else {
                System.out.println("我不知道，请告诉我应该是什么");

                QAObj qaObj = new QAObj();
                qaObj.setQuestion(que);
                qaObj.setAnswer(scanner.nextLine());
                DB.addData(qaObj);

            }

        }
    }

    /**
     * 通过Lucene全文搜索进行数据库查询
     */
    private static void searchAnsByLucene() throws Exception {
        ResultSet rs = DB.searchAll();
        Directory directory = new RAMDirectory();
        Analyzer analyzer = new IKAnalyzer();

        List<String> answers = new ArrayList<>();

        //建立索引
        createIndex(directory, rs, analyzer);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String question = scanner.nextLine();
            answers = getAnswer(directory, question, analyzer);
            String answer = null;
            if (answers != null && answers.size() > 0) {
                answer = answers.get(0);
                System.out.println(answer);
            } else {
                System.out.println("我不知道，请告诉我应该是什么");
                String teacherAns = scanner.nextLine();
                addToDB(question, teacherAns);
                addIndex(directory, question, teacherAns);

            }

        }
    }


    /**
     * 为数据库中的数据字段建立索引
     *
     * @param rs
     */
    private static void createIndex(Directory  directory, ResultSet rs, Analyzer analyzer) throws Exception {

        Document doc = null;
        IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_46, analyzer);
        IndexWriter writer = new IndexWriter(directory,writerConfig);

        try {

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                String answer = rs.getString("answer");

                doc = new Document();
//                StringField idField = new StringField("id", id + "", Field.Store.YES);
                TextField questionField = new TextField("question", question == null ? "" : question, Field.Store.YES);
                TextField answerField = new TextField("answer", answer == null ? "" : answer, Field.Store.YES);

//                doc.add(idField);
                doc.add(questionField);
                doc.add(answerField);
                writer.addDocument(doc);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {

        }

    }


    /**
     * 根据查询语句进行搜索，并将命中结果返回
     *
     * @param queryStr
     */
    private static TopDocs searchByIndex(Directory directory, String queryStr, Analyzer analyzer) {
        TopDocs topDocs = null;
        IndexReader reader = null;
        IndexSearcher searcher = null;

        try {
            reader = DirectoryReader.open(directory);
            searcher = new IndexSearcher(reader);

            QueryParser queryParser = new QueryParser(Version.LUCENE_46, "answer", analyzer);
            queryParser.setDefaultOperator(QueryParser.Operator.AND);
            Query query = queryParser.parse(queryStr);

            topDocs = searcher.search(query, 3);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return topDocs;
    }


    private static List<String> getAnswer(Directory  directory, String queryStr, Analyzer analyzer) {
        TopDocs topDocs = null;
        IndexReader reader = null;
        IndexSearcher searcher = null;

        String answer = null;
        List<String> answers = new ArrayList<>();

        int count = 3;
        Document targetDoc = null;

        try {
            reader = DirectoryReader.open(directory);
            searcher = new IndexSearcher(reader);

            QueryParser queryParser = new QueryParser(Version.LUCENE_46, "question", analyzer);
            queryParser.setDefaultOperator(QueryParser.Operator.AND);
            Query query = queryParser.parse(queryStr);

            topDocs = searcher.search(query, count);

            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (int i = 0; i < topDocs.totalHits; i++) {
                targetDoc = searcher.doc(scoreDocs[i].doc);
                answer = targetDoc.getField("answer").stringValue();
                answers.add(answer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return answers;

    }


    /**
     * 将用户调教答案添加索引
     *
     * @param directory
     * @param teacherAns
     */
    private static void addIndex(Directory directory, String question, String teacherAns) {
        IndexWriter writer = null;
        IndexWriterConfig writerConfig = null;
        writerConfig = new IndexWriterConfig(Version.LUCENE_46, new IKAnalyzer());
        writerConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        Document doc = null;

        try {
            writer = new IndexWriter(directory, writerConfig);
            doc = new Document();
            // StringField idFiled = new StringField("id",null, Field.Store.YES);
            TextField questionField = new TextField("question", question == null?"":question, Field.Store.YES);
            TextField answerFiled = new TextField("answer", teacherAns == null?"":teacherAns, Field.Store.YES);

            // doc.add(idFiled);
            doc.add(questionField);
            doc.add(answerFiled);

            writer.addDocument(doc);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将调教答案存入数据库
     *
     * @param question
     * @param teacherAns
     */
    private static void addToDB(String question, String teacherAns) {
        QAObj qaObj = new QAObj();
        qaObj.setQuestion(question);
        qaObj.setAnswer(teacherAns);
        DB.addData(qaObj);
    }

}
