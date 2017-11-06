package org.alicebot.ab.utils;

import net.reduls.sanmoku.Morpheme;
import net.reduls.sanmoku.Tagger;
import org.alicebot.ab.AIMLProcessor;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.*;


public class JapaneseUtils {

    /**
     * Tokenize a fragment of the input that contains only text
     *
     * @param fragment fragment of input containing only text and no XML tags
     * @return tokenized fragment
     */
    public static String tokenizeFragment(String fragment) {
        //System.out.println("buildFragment "+fragment);
        String result = "";

        //使用日语分词
//        for(Morpheme e : Tagger.parse(fragment)) {
//            result += e.surface+" ";
//            //
////             System.out.println("Feature "+e.feature+" Surface="+e.surface);
//        }

        //使用中文分词
        result = ChineseSegment(fragment);


        return result.trim();
    }

    /**
     * 使用开源中文分词器IKSegmenter
     *
     * @param string
     * @return
     */
    public static String ChineseSegment(String string) {
        if (string.getBytes().length == string.length()) {
            return string;//不包含中文
        }
        StringBuilder sb = new StringBuilder();
        byte[] bt = string.getBytes();
        InputStream ins = new ByteArrayInputStream(bt);
        Reader reader = new InputStreamReader(ins);

        IKSegmenter segmenter = new IKSegmenter(reader, true);//使用智能分词
        Lexeme lexeme;
        try {
            while ((lexeme = segmenter.next()) != null) {
                sb.append(lexeme.getLexemeText() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    /**
     * Morphological analysis of an input sentence that contains an AIML pattern.
     * 包含AIML pattern的输入语句的形态分析
     *
     * @param sentence
     * @return morphed sentence with one space between words, preserving XML markup and AIML $ operation
     * 返回值         使句子的词与词之间有一个空格，保护xml标记和AIML的$操作符
     */
    public static String tokenizeSentence(String sentence) {
        //System.out.println("tokenizeSentence "+sentence);
        if (!MagicBooleans.jp_tokenize) return sentence;
        String result = "";
        result = tokenizeXML(sentence);
        while (result.contains("$ ")) result = result.replace("$ ", "$");
        while (result.contains("  ")) result = result.replace("  ", " ");
        while (result.contains("anon ")) result = result.replace("anon ", "anon"); // for Triple Store
        result = result.trim();
        //if (MagicBooleans.trace_mode) System.out.println("tokenizeSentence '"+sentence+"'-->'"+result+"'");
        return result;
    }

    public static String tokenizeXML(String xmlExpression) {
        //System.out.println("tokenizeXML "+xmlExpression);
        String response = MagicStrings.template_failed;
        try {
            xmlExpression = "<sentence>" + xmlExpression + "</sentence>";
            Node root = DomUtils.parseString(xmlExpression);
            response = recursEval(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AIMLProcessor.trimTag(response, "sentence");
    }

    private static String recursEval(Node node) {
        try {

            String nodeName = node.getNodeName();
            //System.out.println("recursEval "+nodeName);
            if (nodeName.equals("#text")) return tokenizeFragment(node.getNodeValue());
            else if (nodeName.equals("sentence")) return evalTagContent(node);
            else return (genericXML(node));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "JP Morph Error";
    }

    public static String genericXML(Node node) {
        //System.out.println("genericXML "+node.getNodeName());
        String result = evalTagContent(node);
        return unevaluatedXML(result, node);
    }

    public static String evalTagContent(Node node) {
        String result = "";
//        System.out.println("evalTagContent "+node.getNodeName());
        try {
            NodeList childList = node.getChildNodes();
            for (int i = 0; i < childList.getLength(); i++) {
                Node child = childList.item(i);
                result += recursEval(child);
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong with evalTagContent");
            ex.printStackTrace();
        }
        return result;
    }

    private static String unevaluatedXML(String result, Node node) {
        String nodeName = node.getNodeName();
        String attributes = "";
        if (node.hasAttributes()) {
            NamedNodeMap XMLAttributes = node.getAttributes();
            for (int i = 0; i < XMLAttributes.getLength(); i++)

            {
                attributes += " " + XMLAttributes.item(i).getNodeName() + "=\"" + XMLAttributes.item(i).getNodeValue() + "\"";
            }
        }
        if (result.equals(""))
            return " <" + nodeName + attributes + "/> ";
        else return " <" + nodeName + attributes + ">" + result + "</" + nodeName + "> ";   // add spaces
    }
}
