/**
 * 
 */
package javaapplication1;

import java.io.*;

/**
 * @author siddharth
 *
 */
public class FileProcessing {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("/tmp/input.txt"); 
			out = new FileOutputStream("/tmp/output.txt");
			
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}
