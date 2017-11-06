package utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.*;
import java.util.Scanner;

/**
 * 中文分词
 * Created by xkc on 11/11/15.
 */
public class ChineseSegment {

    public static String IKAnalysis(String str){
        if (str.getBytes().length == str.length()){
//            System.out.println("不包含中文："+str);
            return str;//如果不包含中文，直接返回
        }else {
            //IK分词器不支持特殊字符，需要将AIML中的“*”改为“这是星号”，将“_”改为“这是下划线”
            //中文分词以后再将“这是星号”还原为“*”，将“这是下划线”还原为“_”
            str = str.replaceAll("\\*","星号").replaceAll("_","下划线");
        }

//        System.out.println("中文分词前："+str);

        StringBuffer sb = new StringBuffer();

        byte[] bt = str.getBytes();
        InputStream ins = new ByteArrayInputStream(bt);
        Reader reader = new InputStreamReader(ins);

        IKSegmenter iks = new IKSegmenter(reader,true);//设置智能分词useSmart
        Lexeme lexeme;
        try {
            while ((lexeme=iks.next())!=null){
                sb.append(lexeme.getLexemeText()+" ");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = sb.toString().replaceAll("星号","\\*").replaceAll("下划线", "_");
        System.out.println("中文分词后："+result);
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("bye")){
                break;
            }else {
                IKAnalysis(input);
            }
        }
        scanner.close();
    }

}
