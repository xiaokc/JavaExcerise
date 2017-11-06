package demo;

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
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.print.Doc;
import java.io.IOException;

/**
 * 使用IK Analyzer进行Lucene索引和查询
 * Created by xkc on 11/4/15.
 */
public class LuceneIndexAndSearchDemo {
    public static void main(String[] args) {
        //创建一个单条记录的索引并对其进行搜索
        String fieldName = "text";

        //检索内容，即需要建立索引的文档内容
        String text1 = "Lucene全文搜索中文分词工具包测试";
        String text2 = "中文分词工具使用";
        String text3 = "中文分词工具包挺多的";
        String text4 = "中文分词算法博大精深";
        String text5 = "自动问答系统需要用中文分词算法";
        String text6 = "AIML暂时不支持中文分词工具";

        //实例化分词器
        Analyzer analyzer = new IKAnalyzer();

        Directory directory = null;
        IndexWriter writer = null;
        IndexReader reader = null;
        IndexSearcher searcher = null;

        try {
            //建立内存索引对象
            directory = new RAMDirectory();

            //配置IndexWriterConfig
            IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_46, analyzer);
            writerConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            writer = new IndexWriter(directory, writerConfig);


            /**
             * 将三个待索引的文档写入索引，一个Document对象相当于数据库中的一个记录，可以包含多个Field
             * 一个Field对象相当于数据库表中的一个字段
             */

            Document doc1 = new Document();
            doc1.add(new StringField("ID", "1", Field.Store.YES));
            doc1.add(new TextField(fieldName, text1, Field.Store.YES));
            writer.addDocument(doc1);

            Document doc2 = new Document();
            doc2.add(new StringField("ID", "2", Field.Store.YES));
            doc2.add(new TextField(fieldName, text2, Field.Store.YES));
            writer.addDocument(doc2);

            Document doc3 = new Document();
            doc3.add(new StringField("ID", "3", Field.Store.YES));
            doc3.add(new TextField(fieldName, text3, Field.Store.YES));
            writer.addDocument(doc3);

            Document doc4 = new Document();
            doc4.add(new StringField("ID", "4", Field.Store.YES));
            doc4.add(new TextField(fieldName, text4, Field.Store.YES));
            writer.addDocument(doc4);

            Document doc5 = new Document();
            doc5.add(new StringField("ID", "5", Field.Store.YES));
            doc5.add(new TextField(fieldName, text5, Field.Store.YES));
            writer.addDocument(doc5);

            Document doc6 = new Document();
            doc6.add(new StringField("ID", "6", Field.Store.YES));
            doc6.add(new TextField(fieldName, text6, Field.Store.YES));
            writer.addDocument(doc6);

            writer.close();


            //搜索过程＊＊＊＊＊＊＊＊＊
            //实例化搜索器
            reader = DirectoryReader.open(directory);
            searcher = new IndexSearcher(reader);

            //要搜索的内容
            String keyword = "中文分词工具";
            //使用QueryParser查询分析器构造Query对象
            QueryParser queryParser = new QueryParser(Version.LUCENE_46, fieldName, analyzer);
            queryParser.setDefaultOperator(QueryParser.AND_OPERATOR);
            Query query = queryParser.parse(keyword);//Query:+text:中文 +text:分词 +text:工具
            System.out.println("Query:" + query);


            int count = 4;

            //搜索相似度最高的count条记录
            TopDocs topDocs = searcher.search(query, count);
            System.out.println("命中：" + topDocs.totalHits);
            //输出结果
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (int i = 0; i < count; i++) {
                Document targetDoc = searcher.doc(scoreDocs[i].doc);
                System.out.println("内容：" + targetDoc.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
