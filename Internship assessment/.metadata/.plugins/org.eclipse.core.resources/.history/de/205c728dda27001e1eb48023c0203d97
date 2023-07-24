package com.springboot.test.util;

import java.util.zip.Deflater;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class FileUtils {
	
	public static byte[] compressFile(byte[] file) {
		Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(file);
		deflater.finish();
		
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		byte[] tmp = new byte[4*1024];
		while(!deflater.finished()) {
			int size = deflater.deflate(tmp);
			outputstream.write(tmp,0, size);
			
		}
		try {
			outputstream.close();
		}
		catch(Exception ignored) {
			ignored.printStackTrace();
		}
		return outputstream.toByteArray();
	}
	
	
}
