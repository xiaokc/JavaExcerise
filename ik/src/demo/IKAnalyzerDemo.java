package demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by xkc on 11/3/15.
 */
public class IKAnalyzerDemo {

    public static void main(String[] args){

        //构造IK分词器，采用智能切分，false表示最细粒度切分
        Analyzer analyzer = new IKAnalyzer(true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;


        try {
            ts = analyzer.tokenStream("myField",new StringReader("中文分词测试，能识别英文吗？Hello Lucene's World! "));

            //获取词元位置属性
            OffsetAttribute offsetAttr = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute charTermAttr = ts.addAttribute(CharTermAttribute.class);
            //获取词元类别属性
            TypeAttribute typeAttr = ts.addAttribute(TypeAttribute.class);

            //重置TokenStream(重置StringReader)
            ts.reset();
            //迭代获取分词结果
            while(ts.incrementToken()){
                System.out.print(offsetAttr.startOffset()+"-"+offsetAttr.endOffset()+":"+charTermAttr.toString()+"|"+typeAttr.type());
            }

            ts.end();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ts != null){
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
