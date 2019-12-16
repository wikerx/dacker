package com.scott.ds.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 自定义AES 加解密工具类；
 * 目前这个暂时不使用，本项目使用 jasypt 
 * @author Administrator
 *
 */
public class AESUtils {
	/**
	 * 密钥
	 */
	private static String KEY = "x3/eqbraBj0pFyKLza21lq3nj7TP31Wz86DQZEKEszm9NRO/JxKmUTpwBOBslGF0xS3NtT2m3EHYieymCMbQQ/8j68SZNg/5DHH+pznp3P5f65lcIYsVh3mP5fjhPI6vaYthmG0QOd/bFjzxrSMvP8Fi=/vHezHNwiZ8siAcQF3yXgStuTE3tH9tV8IOLJPpRrjRXqNCAOCjVZtpJRun6OBb";
	/**
	 * 签名算法
	 */
	private static final String SIGN_ALGORITHMS  = "SHA1PRNG";
	/**
	* 加密算法
	*/
	public static final String KEY_ALGORITHM = "AES";
	/**
	* 编码格式
	*/
	private static final String ENCODING = "UTF-8";
	
	/*
	 * 加密
	 */
	public static String AESEncode(String content) {
		return AESEncode(content,KEY);
	}
	/*
	 * 加密
	 */
	public static String AESEncode(String content,String pkey) {
		if(pkey == null) pkey = KEY;
		try {
			// 1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keygen = KeyGenerator.getInstance(KEY_ALGORITHM);
			//故调整为如下方式
			SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
			random.setSeed(pkey.getBytes(ENCODING));
			keygen.init(128, random);
			SecretKey original_key = keygen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byte_encode = content.getBytes(ENCODING);
			byte[] byte_AES = cipher.doFinal(byte_encode);
			String AES_encode = new String(Base64.encodeBase64(byte_AES));
			return AES_encode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/*
	 * 解密 
	 */
	public static String AESDncode(String content) {
		return AESDncode(content,KEY);
	}

	public static String AESDncode(String content,String pkey) {
		if(pkey == null) pkey = KEY;
		try {
			KeyGenerator keygen = KeyGenerator.getInstance(KEY_ALGORITHM);
			//故调整为如下方式
			SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
			random.setSeed(pkey.getBytes(ENCODING));
			keygen.init(128, random);
			SecretKey original_key = keygen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] byte_content = Base64.decodeBase64(content);
			byte[] byte_decode = cipher.doFinal(byte_content);
			String AES_decode = new String(byte_decode, ENCODING);
			return AES_decode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) {
		String aesEncode = AESEncode("Zmt123456");
		System.out.println(aesEncode);
		System.out.println(AESDncode("0CyPOqHKCSts1MguK1NXygeOhMgVh40OdD9nhjj8k59CMKDZiOUhqVA8c/i2HWgB"));
	}
}
