package java_base;
import java.io.*;
import java.util.Scanner;
public class IOTest {

    public  void sysIO() throws IOException{
        
        // 字符流和字节流 处理流和节点流 我感觉所有的字符流都像是处理流或者装饰者(从更底层一点来看,都是对字节流的封装)
        // 但是一般将其理解为不管是字符流或者字节流都有节点流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = 0;
        //输入缓冲区什么, 就输出到控制台什么
        while((c=(char) br.read())!=-1)
            System.out.print(c);
    }

    public static void scanerIO(){
        /**
         * Java5 新特性 
         */
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a+b);
        scanner.close();
    }



    public static void main(String[] args) throws IOException{
        // sysIO();
        scanerIO();
    }
}
