import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
输入
 */
public class IODemo {
    /*
    1.可以从文件中读
    2.可以从网络中读（网卡/TCP连接）
    3.可以从内存中读（内存中的一段空间当成输入源）
    4.可以从标准输入读
    @return
     */
    /*
    1.直接通过字节方式读，然后程序进行字符编码
    2.把Stream转化为Reader，进行字符形式读取
        2.1直接读
        2.2BufferedReader   readline
    3.Scanner也可以
     */

    private static InputStream 获得一个输入流() throws IOException {
        InputStream inputStream;
        inputStream = new FileInputStream("本地文件.txt");
        return inputStream;

        /*InputStream inputStream;
        byte[] bytes = "我只是内存中的一段空间\r\n第二行\r\n".getBytes("UTF-8");
        inputStream = new ByteArrayInputStream(bytes);
        return inputStream;*/

        /*InputStream inputStream;
        inputStream = System.in;
        return inputStream;*/

       /* InputStream inputStream;
        Socket socket = new Socket("www.baidu.com",80);
        OutputStream os = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(os,"UTF-8");
        PrintWriter printWriter = new PrintWriter(writer,false);
        printWriter.printf("GET / HTTP / 1.0\r\n\r\n");
        printWriter.flush();
        inputStream = socket.getInputStream();
        return inputStream;*/
    }
    private static String 从字节流中最终获得字符数据(InputStream is) throws IOException {
        /*byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        String message = new String(buffer,0,len,"UTF-8");
        return message;*/

        /*Reader reader = new InputStreamReader(is,"UTF-8");
        char[] buffer = new char[1024];
        int len = reader.read(buffer);
        String message = new String(buffer,0,len);
        return message;*/

        /*StringBuilder sb = new StringBuilder();
        Reader reader = new InputStreamReader(is,"UTF-8");
        char[] buffer = new char[10];
        int len;
        while ((len = reader.read(buffer)) != -1){
            sb.append(buffer,0,len);
        }
        String message = sb.toString();
        return message;*/

        /*Reader reader = new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            sb.append(line + "\r\n");
        }
        return sb.toString();*/

        Scanner sc = new Scanner(is);
        return sc.nextLine()+sc.nextLine();
    }

   private static OutputStream 获取一个输出流() throws FileNotFoundException {
        OutputStream os = new FileOutputStream("本地输出文件.txt");
        //Socket socket = new Socket("www.baidu.com",80);
       //OutputStream os = socket.getOutputStream();
       //OutputStream os = new ByteArrayOutputStream();
        return os;
    }

    private static void 输出一段字符(OutputStream os,String message) throws UnsupportedEncodingException {
        /*
        byte[] buffer = message.getBytes("UTF-8");
        os.write(buffer);
         */
        Writer writer = new OutputStreamWriter(os,"UTF-8");
        //writer.append(message);
        //writer.flush();
        PrintWriter printWriter = new PrintWriter(writer,false);
        printWriter.printf("%s",message);
        printWriter.flush();
    }

    public static void main(String[] args) throws IOException {
        /*InputStream is = 获得一个输入流();
        String message = 从字节流中最终获得字符数据(is);
        System.out.println(message);*/

        OutputStream os = 获取一个输出流();
        输出一段字符(os,"我是中国人，最喜欢过年了\r\n");
    }
}
