package com.project3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;

import com.google.common.hash.Hashing;
//import com.google.common.hash.HashingInputStream;

public class Util {
	public static final String PATHFILE = "birthday.mp4";
	private static FileInputStream file;

	public static byte[] readFile(String path) throws IOException {

		return Files.readAllBytes(Paths.get(path));

	}

	public static byte[] mergeBytes(byte[] firstArray, byte[] secondArray) {
		int fal = firstArray.length;
		int sal = secondArray.length;
		byte[] result = new byte[fal + sal];
		System.arraycopy(firstArray, 0, result, 0, fal);
		System.arraycopy(secondArray, 0, result, fal, sal);
		return result;
	}

}
