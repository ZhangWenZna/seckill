package com.atzwz.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * MD5工具类
 */
@Component
public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt="1a2b3c4d";

    public static String inputPassToFromPass(String inputPass){
        String str=""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);

    }

    public static String fromPassToDBPass(String formPass,String salt){
        String str=""+salt.charAt(5)+salt.charAt(2)+formPass+salt.charAt(1)+salt.charAt(0);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("122333zwz"));
        System.out.println(fromPassToDBPass("ed0db368cd45d79a39f94d0e9ceacd23", "1a2b3c4d"));
        System.out.println(inputPassToDBPass("122333zwz", "1a2b3c4d"));
    }
}
