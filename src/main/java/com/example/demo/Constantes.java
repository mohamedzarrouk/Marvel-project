package com.example.demo;


import org.apache.commons.codec.digest.DigestUtils;

public class Constantes {

	public static final int TS = 1;
	
	public static final String API_PUBLIC_KEY = "72cf3da79cbd9ea41e13a326f29cdfa3";
	
	public static final String GENERIC_API_KEY ="4093c8fb647803b1f691c6e95196730e";
	
	public static final String API_PRIVATE_KEY = System.getenv("privateKey");
	
	public static final String TOHASH = TS + API_PRIVATE_KEY + API_PUBLIC_KEY;
	
    public static final String HASH = DigestUtils.md5Hex(TOHASH);
	

}
