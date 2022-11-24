package icu.javacg.zyshop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestJava {

    @Test
    public void test1() {
        String si = "你好，这个世界郝文韬郝文韬郝文韬郝文韬郝文韬郝文韬";
        char[] chars = si.toCharArray();
        char[] chars2 = new char[10];
        System.arraycopy(chars, 0, chars2, 0, 10);
        /*char[] chars3 = new char[10];
        chars3 = si.toCharArray();*/
        String s = new String(chars2);
        System.out.println(s);
    }
}
