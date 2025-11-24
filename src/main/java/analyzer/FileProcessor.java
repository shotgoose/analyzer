package analyzer;

import java.util.Scanner;

import dataframe.DataFrame;
import dataframe.Template;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor {
	
	public static DataFrame readDataFile(String path) {
		
		DataFrame dataframe;
		
		try {
			File file = new File(path);
			
			Scanner scanner = new Scanner(file);
			
			String[] headers = scanner.nextLine().split(",");
			
			String[] ids = new String[headers.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i] = headers[i].replaceFirst("[^a-zA-Z0-9].*$", "").toLowerCase();
			}
			
			int lines = countLines(new Scanner(file));
			int columns = headers.length;
			
			double[][] values = new double[lines][columns];
			
			int line = 0;
			while (scanner.hasNextLine()) {
				values[line] = readDataLine(scanner.nextLine(), columns);
			}
			
			dataframe = new DataFrame(values, ids, headers);
			
			scanner.close();
		}
		catch (FileNotFoundException e) {
			return null;
		}
		
		return dataframe;
	}
	
	public static Template readTemplateFile(String path) {
		String[] instructions;
		
		try {
			File file = new File(path);
			
			Scanner scanner = new Scanner(file);
			int lines = countLines(new Scanner(file));
			instructions = new String[lines];
			
			for (int i = 0; i < lines; i++) {
				instructions[i] = scanner.nextLine();
			}
			
			scanner.close();
		}
		catch (FileNotFoundException e) {
			return null;
		}
		
		return new Template(instructions);
	}
	
	private static double[] readDataLine(String line, int columns) {
		
		String[] split = line.split(",");
		double[] row = new double[split.length];
		for (int i = 0; i < split.length; i++) {
			row[i] = Double.parseDouble(split[i]);
		}
		
		return row;
	}
	
	/**
	 * Count lines in the scanner
	 * 
	 * @param scanner
	 * @return lines in scanner
	 */
	public static int countLines(Scanner scanner) {
		int lines = 0;
		while (scanner.hasNextLine()) {
			lines++;
			scanner.nextLine();
		}
		scanner.close();
		
		return lines;
	}
	
	public static void writeDataFile(String path, DataFrame dataframe) {
		
		
	}
	
	public static void writeTemplateFIle(String path, Template template) {
		
	}

}
