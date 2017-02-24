/**
 * 
 */
package javaapplication1;

import java.io.*;
import java.util.*;

/**
 * @author siddharth
 *
 */
class ReadOneFile {
	public void readOneFile() throws IOException {
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

class ReadMultipleFileSequentially {
	public int getFileSize() {
		return 1;
	}
	
	public File[] getFiles() {
		File f = null;
		File paths[] = null;
		String retArr[];
		int countOfFiles = 0;
		try {
			f = new File("/tmp/temp/");
			paths = f.listFiles();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return paths;
	}
	
	public void readMultipleFiles(File[] files) {
		try {
			HashMap fileObj = new HashMap();
			
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
				FileReader fr = new FileReader("/tmp/temp/"+files[i].getName());
				BufferedReader br = new BufferedReader(fr);
				fileObj.put("fr"+i, fr);
				fileObj.put("br"+i, br);
			}
//			System.out.println(fileObj);System.exit(0);
			Set s = fileObj.entrySet();
			Iterator i = s.iterator();
			while(i.hasNext()) {
				Map.Entry m = (Map.Entry)i.next();
			}
				
//			for (Map.Entry m:fileObj.entrySet().iterator()) {
//				m.getValue();
//			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void execute() {
		File[] files = this.getFiles();
		this.readMultipleFiles(files);
	}
}

class BufferReaderExample {
	public void readBufferedReaderExample() throws IOException {
		FileReader fr = new FileReader("/tmp/abc.txt");
		BufferedReader br = new BufferedReader(fr);
		String i;
		while ((i=br.readLine()) != null)
			System.out.println(i);

		br.close();
		fr.close();
	}
}

public class FileProcessing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		///////////Read One File///////////////////////////////
//		ReadOneFile r = new ReadOneFile();
//		r.readOneFile();
		
		//////////////Buffered Reader Example///////////////////
//		BufferReaderExample br = new BufferReaderExample();
//		br.readBufferedReaderExample();
		
		///////////////Read Multiple Files//////////////////////
		ReadMultipleFileSequentially rm = new ReadMultipleFileSequentially();
		rm.execute();
	}

}
