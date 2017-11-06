package main;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xkc on 11/6/15.
 */
public class LuceneUtils {
    private Directory directory = null;
    private ResultSet rs;
    private Analyzer analyzer;



    /**
     * 为数据库中的数据字段建立索引
     *
     * @param rs
     */
    private static void createIndex(Directory directory, ResultSet rs, Analyzer analyzer) throws Exception {
        IndexWriterConfig writerConfig = null;
        IndexWriter writer = null;
        Document doc = null;

        try {
            writerConfig = new IndexWriterConfig(Version.LUCENE_46, analyzer);
            writer = new IndexWriter(directory, writerConfig);

            while (rs.next()) {
                String question = rs.getString("question");
                String answer = rs.getString("answer");

                doc = new Document();
                TextField questionField = new TextField("question",question == null ? "":question, Field.Store.YES);
                TextField answerField = new TextField("answer", answer == null ? "":answer, Field.Store.YES);

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
}
