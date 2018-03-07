package com.coder520.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author : Hellxz
 * @Description: 安全工具
 * @Date : 2018/3/7 9:46
 */
public class SecurityUtils {

    /**
     * @Description: 加密密码
     * @Params: String password
     * @Return: String
     * @Date: 2018/3/7 9:46
     */
    public static String encryptPwd(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //获取md5加密算法对象
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //防止加密乱码
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //设置字符集并base64转码
        String encode = base64Encoder.encode(md5.digest(password.getBytes("UTF-8")));
        return encode;
    }

    /**
     * @Description:检查密码是否匹配数据库
     * @Params: inputPwd输入的密码,dbPwd输出的密码
     * @Return: boolean
     * @Date: 2018/3/7 9:47
     */
    public static boolean checkPwd(String inputPwd, String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //加密输入密码
        String md5Pwd = encryptPwd(inputPwd);
        //判断通过返回true
        if(inputPwd != null && dbPwd != null && md5Pwd.equals(dbPwd)){
            return true;
        }
        return false; //其余的情况都return false，因为不合法
    }

}
