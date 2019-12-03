package my;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class MyIO {

    /**
     * 字节流写文件
     *
     * @throws IOException
     */
    public static void writeByteToFile() throws IOException {
        String str = "Hello World";
        byte[] strBytes = str.getBytes();
        File file = new File("/Users/will/Desktop/helloworld.txt");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(strBytes);
        outputStream.close();
    }

    /**
     * 用字节缓冲流写文件
     *
     * @throws IOException
     */
    public static void writeByBufferedInputStream() throws IOException {
        String str = "Hello World";
        byte[] strBytes = str.getBytes();
        File file = new File("/Users/will/Desktop/helloworldbuffer.txt");
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file), 2 * 1024);
        outputStream.write(strBytes);
        outputStream.close();
    }


    //-----------------

    /**
     * 字节流读文件
     *
     * @throws IOException
     */
    public static void readByteFromFile() throws IOException {
        long start = System.currentTimeMillis();
        File file = new File("/Users/will/Desktop/helloworld.txt");
        byte[] strBytes = new byte[(int) file.length()];
        InputStream inputStream = new FileInputStream(file);
        int size = inputStream.read(strBytes);
        inputStream.close();
        System.out.println("时间：" + (System.currentTimeMillis() - start) + "ms,文件大小：" + size + "，内容：\n" + new String(strBytes));
    }

    /**
     * 用字节缓冲流读文件
     *
     * @throws IOException
     */
    public static void readByBufferedInputStream() throws IOException {
        long start = System.currentTimeMillis();
        File file = new File("/Users/will/Desktop/helloworld.txt");
        byte[] strBytes = new byte[(int) file.length()];
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file), 2 * 1024);
        int size = inputStream.read(strBytes);
        inputStream.close();
        System.out.println("时间：" + (System.currentTimeMillis() - start) + "ms,文件大小：" + size + "，内容：\n" + new String(strBytes));
    }





    //==================================================



    /**
     * 字符流写文件
     *
     * @throws IOException
     */
    public static void writeCharToFile() throws IOException {
        String str = "Hello World";
        File file = new File("/Users/will/Desktop/helloworldWrite.txt");
        Writer writer = new FileWriter(file);
        writer.write(str);
        writer.close();
    }

    /**
     * 字符缓冲流写文件
     *
     * @throws IOException
     */
    public static void writerBufferCharToFile() throws IOException {
        String str = "Hello World";
        File file = new File("/Users/will/Desktop/helloworldWritebuffer.txt");
        Writer writer = new BufferedWriter(new FileWriter(file), 2 * 1024);
        writer.write(str);
        writer.close();
    }


    //-----------------


    /**
     * 字符流读文件
     *
     * @throws IOException
     */
    public static void readCharFromFile() throws IOException {
        File file = new File("/Users/will/Desktop/helloworldWrite.txt");
        char[] strChars = new char[(int) file.length()];
        Reader reader = new FileReader(file);
        int size = reader.read(strChars);
        reader.close();
        System.out.println("文件大小：" + size + "，内容：\n" + new String(strChars));
    }

    /**
     * 字符缓冲流读文件
     *
     * @throws IOException
     */
    public static void readerBufferCharFromFile() throws IOException {
        File file = new File("/Users/will/Desktop/helloworldWritebuffer.txt");
        char[] strChars = new char[(int) file.length()];
        Reader reader = new BufferedReader(new FileReader(file), 2 * 1024);
        int size = reader.read(strChars);
        reader.close();
        System.out.println("文件大小：" + size + "，内容：\n" + new String(strChars));
    }


    //==================================================



    /**
     * 字节流转字符流，读文件
     *
     * @throws IOException
     */
    public static void inputStreamReadCharFromFile() throws IOException {
        File file = new File("/Users/will/Desktop/helloworldWrite.txt");
        InputStream inputStream = new FileInputStream(file);
        char[] strChars = new char[(int) file.length()];
        Reader reader = new InputStreamReader(inputStream);
        int size = reader.read(strChars);
        reader.close();
        System.out.println("文件大小：" + size + "，内容：\n" + new String(strChars));
    }


    //==================================================



    /**
     * 随机读取文件内容
     *
     * @throws IOException
     */
    public static void randomAccessFileRead() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/will/Desktop/helloworldWrite.txt", "rw");
        byte[] contents = new byte[1024];
        file.seek(10);
        long pointerBegin = file.getFilePointer();
        file.read(contents);
        long pointerEnd = file.getFilePointer();
        System.out.println(pointerBegin + "-" + pointerEnd + ":" + new String(contents));
        file.close();
    }

    /**
     * 随机写入文件
     *
     * @throws IOException
     */
    public static void randomAccessFileWrite() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/will/Desktop/helloworldWrite1.txt", "rw");
        file.seek(10);
        long pointerBegin = file.getFilePointer();
        file.write("Hello World".getBytes());
        long pointerEnd = file.getFilePointer();
        System.out.println(pointerBegin + "-" + pointerEnd);
        file.close();
    }


    //==================================================


    /**
     * 同进程不同线程间，管道数据交互
     *
     * @throws IOException
     */
    public static void pipedExample() throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    out.write("Hello Word pipe,Hello Word pipe,Hello Word pipe,Hello Word pipe,Hello Word pipe!".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (in.available() != 0) {
                        System.out.print((char) in.read());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        readerBufferCharFromFile();
    }
}
