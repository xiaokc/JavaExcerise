package main;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xkc on 11/11/15.
 */
public class AIMLChat {
    private static final String END = "bye";

    public static String userInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = "";

        try {
            inputText = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputText;

    }


    public static void main(String[] args) {

//        useChatterbean();

//        useProgramAB();

        useAIML2ProgramAB();


    }

    /**
     * AIML2.0支持简单的中文分词：每两个汉字之间以空格隔开
     */
    private static void useAIML2ProgramAB() {
        String botName = "rosie";
        String botPath = "/Users/xkc/IdeaProjects/test/faq";
        Bot chatBot = new Bot(botName,botPath,"chat");
        Chat chatSession = new Chat(chatBot);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request="";
        String response="";
        MagicBooleans.trace_mode=false;
        System.out.println("Alice>"+chatSession.multisentenceRespond("欢迎"));
        while (true){
            try {
                request=reader.readLine();
                response = chatSession.multisentenceRespond(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Alice>"+response);
        }
    }

    private static void useChatterbean(){
        AliceBotMother mother = new AliceBotMother();
        mother.setUp();
        try {
            AliceBot bot = mother.newInstance();
            String initResponse = bot.respond("welcome");
//            System.out.println(bot.respond("你"));
            System.out.println("Alice>"+initResponse);
            while (true){
                String input = userInput();
                if (AIMLChat.END.equalsIgnoreCase(input)){
                    break;
                }
                System.out.println("Alice>"+bot.respond(input));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void useProgramAB() {
        Pattern pattern = Pattern.compile("[A-Z0-9\u4E00-\u9FA5]*");

        String botName = "alice2";
        String botPath = "/Users/xkc/IdeaProjects/test/faq";
        Bot chatBot = new Bot(botName,botPath,"chat");
        Chat chatSession = new Chat(chatBot);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request="";
        String response="";
        MagicBooleans.trace_mode=false;
        while (true){
            try {
                request=reader.readLine();
                Matcher matcher =  pattern.matcher(request);
                StringBuffer sb = new StringBuffer();
                while (! matcher.hitEnd() && matcher.find()){
                    matcher.appendReplacement(sb," "+ matcher.group()+" ");
                }
                matcher.appendTail(sb);
                response = chatSession.multisentenceRespond(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(response);
        }
    }
}
