package com.scott.ds.utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/**
 * @ClassName :EncryptionUtil
 * @Description :加密工具
 * @Author :Mr.薛
 * @Data :2019/11/7  10:40
 * @Version :V1.0
 * @Status : 编写
 **/
public class EncryptionUtil {
    private static Log log = LogFactory.getLog(EncryptionUtil.class);

    /**
     * HmacSHA1加密
     * @param data
     * @param key
     * @return
     */
    public static String hamcsha1(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将HmacSHA1加密之后的内容转换为字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    /**
     * 生成一个64位的随机秘钥
     * */
    public static String getRandomString(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<64;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 将字符串 - 秘钥通过SHA1加密生成密文数据
     * @param data : 原字符串
     * @param saltKey ：秘钥
     * @return 加密数据
     * */
    public static String encrySha1(String data,String saltKey){
        return hamcsha1(data.getBytes(),saltKey.getBytes());
    }

    public static void main(String[] args) {
        String data = "asdwbdhfb234r5411sd2f15er4f";
        String saltKey = getRandomString();
        log.info("原数据：" + data);
        log.info("秘钥：" + saltKey);
        log.info("加密数据：" + encrySha1(data,saltKey));
    }

}
