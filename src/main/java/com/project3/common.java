package com.project3;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import com.google.common.hash.Hashing;

public class common {
	private static byte[] bsInput;

	public static void main(String[] args) throws IOException {
		String result = solution();
		System.out.println(result);
	}

	public static String solution() throws IOException {

		bsInput = Util.readFile(Util.PATHFILE);

		int lengthBlockN = bsInput.length % 1024;
		byte[] bsN = new byte[lengthBlockN];
		byte[] bs = new byte[1024];
		byte[] bsNHash = new byte[1024];
		int indexBlockN = lengthBlockN - 1;
//		int k = bsInput.length;
		int l = 1023;
//		int count = 0;
		for (int i = bsInput.length - 1; i >= 0; i--) {
			if (lengthBlockN != 0) {

				bsN[indexBlockN] = bsInput[i];
//				System.out.println(bsInput[i] + " "+ bsN[indexBlockN]);
				indexBlockN--;
				if (indexBlockN == -1) {
//					System.out.println(bsN[0]);
					bsNHash = Hashing.sha256().hashBytes(bsN).asBytes();
					lengthBlockN = 0;
					l = 1023;
					continue;
				}
			}

			bs[l] = bsInput[i];
			l--;
			if (l == -1) {
				l = 1023;
//				count++;
				bsNHash = Hashing.sha256().hashBytes(Util.mergeBytes(bs, bsNHash)).asBytes();
			}

		}
//		System.out.println(bsN[0]);
		return Hex.encodeHexString(bsNHash);
	}

}
