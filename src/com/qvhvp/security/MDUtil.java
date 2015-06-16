package com.qvhvp.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;

public class MDUtil {
	private static String src = "nice";

	public static void main(String[] args) {
		jdkMD5(src);
		jdkMD2(src);
		bcMD4(src);
		bcMD5(src);
		ccMD5(src);
	}

	public static void jdkMD5(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("jdk MD5:" + Hex.encodeHexString(md5bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	public static void jdkMD2(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("md2");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("jdk MD2:" + Hex.encodeHexString(md5bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	public static void bcMD4(String src){
//		Security.addProvider(new BouncyCastleProvider());
//		try {
//			MessageDigest md = MessageDigest.getInstance("md4");
//			byte[] md4bytes = md.digest(src.getBytes());
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
		Digest digest=new MD4Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md4Bytes=new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		System.out.println("BC MD4:"+org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}
	
	public static void bcMD5(String src){
		Digest digest=new MD5Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md5Bytes=new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("BC MD5:"+org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	
	public static void ccMD5(String src){
		System.out.println("CC MD5:"+DigestUtils.md5Hex(src));
	}
}
