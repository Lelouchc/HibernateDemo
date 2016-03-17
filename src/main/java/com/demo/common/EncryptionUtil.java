package com.demo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yy on 2016/3/8.
 * 使用Java自带的MessageDigest类加密
 */
public class EncryptionUtil {
    /**
     * 使用格式化方式，将加密后的数据转换成16进制
     *
     * @param source   需要加密的字符串
     * @param hashType 加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash(String source, String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当前系统加密方式（MD5->SHA1）
     *
     * @param password
     * @return
     */
    public static String encryptMS1(String password) {
        return getHash(SystemUtil.ENCRYPT + getHash(password, "MD5"), "SHA1");
    }

    /**
     * 当前系统加密方式（SHA1->MD5）
     *
     * @param password
     * @return
     */
    public static String encryptS1M(String password) {
        return getHash(SystemUtil.ENCRYPT + getHash(password, "SHA1"), "MD5");
    }

    /**
     * 当前系统加密方式（MD5->MD5）
     *
     * @param password
     * @return
     */
    public static String encryptMM(String password) {
        return getHash(SystemUtil.ENCRYPT + getHash(password, "MD5"), "MD5");
    }

    /**
     * 当前系统加密方式（SHA1->SHA1）
     *
     * @param password
     * @return
     */
    public static String encryptS1S1(String password) {
        return getHash(SystemUtil.ENCRYPT + getHash(password, "SHA1"), "SHA1");
    }
}
