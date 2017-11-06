import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * Created by xkc on 9/12/16.
 */
public class FileCopy {
    public static void main(String[] args) {
        File source = new File("/Users/xkc/IdeaProjects/test/commonjava/src/test1.txt");
        File dest = new File("/Users/xkc/IdeaProjects/test/commonjava/src/test2.txt");
//        copyByFileStreams(source, dest);
//        copyByFileChannels(source,dest);
        copyByJava7Files(source,dest);



    }

    /**
     * 使用java.io.File中的FileInputStream和FileOutputStream实现文件复制
     *
     * @param source
     * @param dest
     */
    public static void copyByFileStreams(File source, File dest) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);

            /**
             * 一次性把数据全部读取到内存中，再一次性写入数据
             */
            byte[] b = new byte[(int) source.length()];
            inputStream.read(b);
            outputStream.write(b);


            /**
             * 边读边写
             */
//            int len = 0;
//            while ((len = inputStream.read()) != -1){
//                outputStream.write(len);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    /**
     * 使用java.nio.channels中的transferFrom方法，将文件source拷贝到文件dest中
     * 从API文档中可以看到该方法比FileStream执行更快的复制操作
     * @param source
     * @param dest
     */
    public static void copyByFileChannels(File source, File dest) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);

            FileChannel inputChannel = inputStream.getChannel();
            FileChannel outputChannel = outputStream.getChannel();

            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 使用java7的Files.copy完成拷贝操作，其内部也是使用FileChannels
     * @param source
     * @param dest
     */
    public static void copyByJava7Files(File source, File dest) {
        try {
            Files.copy(source.toPath(),dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
