package javaapplication1;

import java.io.*;

public class StandardInput {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		System.out.println("Write characters: q to quit");
		try {
			char c;
			do {
				c = (char) in.read();
				System.out.println(c);
			} while (c != 'q');
		} finally {
			if (in != null)
				in.close();
		}
	}

}