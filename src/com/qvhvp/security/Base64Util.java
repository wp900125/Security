package com.qvhvp.security;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
	private static String src="1234567890";
	public static void main(String[] args) {
		bouncyCastleBase64(src);
		apacheCommonsCodecBase64(src);
	}
	
	public static void apacheCommonsCodecBase64(String src){
		byte[] encodeBytes=Base64.encodeBase64(src.getBytes());
		System.out.println("encode: "+new String(encodeBytes));
		
		byte[] decodeBytes=Base64.decodeBase64(encodeBytes);
		System.out.println("decode: "+new String(decodeBytes));
	}
	
	public static void bouncyCastleBase64(String src){
		byte[] encodeBytes=org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode: "+new String(encodeBytes));
		
		byte[] decodeBytes=org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("decode: "+new String(decodeBytes));
	}
}
