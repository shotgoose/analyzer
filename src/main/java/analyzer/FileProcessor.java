package analyzer;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class FileProcessor {
	
	public static DataFrame readFile(String path) {
		
		try {
			Scanner scan = new Scanner(new FileInputStream(path));
		}
		catch (FileNotFoundException e) {
			
		}
		
		return new DataFrame();
		
	}
	
	public static void writeFile(String path) {
		
	}

}
