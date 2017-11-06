package main;

import org.alicebot.ab.utils.JapaneseUtils;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import utils.ChineseSegment;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xkc on 11/23/15.
 */
public class Test {
    public static void main(String[] args){
//        testRegex("\"123\",\"dff\"");

//        testStringRegex("\\1234\\!");
        String string = "你好，我不是机器人，北京市海淀区";
        String useJPUtilString = JapaneseUtils.tokenizeSentence(string);
        String useCNSegmentString = ChineseSegment(string);
        System.out.println(useJPUtilString);

    }

    private static void testStringRegex(String string) {
        String[] result = string.split("[\\.!\\?]");//[\.!\?]
        for (int i = 0; i < result.length; i ++){
            System.out.println(result[i]);
        }
    }

    public static void testRegex(String string) {
        Pattern pattern = Pattern.compile("\"(.*?)\",\"(.*?)\"", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(string);
        String[] subs = new String[20];
        System.out.println(matcher.find());
        if (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                subs[i] = matcher.group(i);

                System.out.println(subs[i]);
            }
        }
    }

    public String[] sentenceSplit(String line) {
        line = line.replace("。",".");
        line = line.replace("？","?");
        line = line.replace("！","!");
        //System.out.println("Sentence split "+line);
        String result[] = line.split("[\\.!\\?]");
        for (int i = 0; i < result.length; i++) result[i] = result[i].trim();
        return result;
    }


    public static String ChineseSegment(String string){
        if (string.getBytes().length == string.length()){
            return string;//不包含中文
        }
        StringBuilder sb = new StringBuilder();
        byte[] bt = string.getBytes();
        InputStream ins = new ByteArrayInputStream(bt);
        Reader reader = new InputStreamReader(ins);

        IKSegmenter segmenter = new IKSegmenter(reader,true);//使用智能分词
        Lexeme lexeme;
        try {
            while ((lexeme = segmenter.next()) != null){
                sb.append(lexeme.getLexemeText()+" ");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return sb.toString();
    }


}
