package java_base;

import java.lang.String;

public class StringTest {
    public static void main(String[] args) {
        // String s = new String("1");
        // s.intern();
        String s = "1";
        String s2 = "1";
        System.out.println(s == s2);

        String s4 = "11";
        String s3 = new String("1") + new String("1");
        s3.intern();
        System.out.println(s3 == s4);
    }
}
