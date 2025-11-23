package analyzer;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import dataframe.Column;
import dataframe.DataFrame;

public class FileProcessor {
	
	public static DataFrame readFile(String path) {
		
		DataFrame dataframe;
		
		try {
			File file = new File(path);
			
			Scanner scanner = new Scanner(file);
			
			String[] headers = scanner.nextLine().split(",");
			
			int lines = countLines(new Scanner(file));
			int columns = headers.length;
			
			double[][] values = new double[lines][columns];
			
			int line = 0;
			while (scanner.hasNextLine()) {
				values[line] = readLine(scanner.nextLine(), columns);
			}
			
			double[][] transpose = transpose(values);
			Column[] cols = new Column[values.length];
			for (int i = 0; i < values.length; i++) {
				cols[i] = new Column(values[i]);
			}
			dataframe = new DataFrame(headers, cols);
			
			scanner.close();
		}
		catch (FileNotFoundException e) {
			return null;
		}
		
		return dataframe;
		
	}
	
	public static double[] readLine(String line, int columns) {
		
		String[] str = line.split(",");
		double[] vals = new double[str.length];
		for (int i = 0; i < str.length; i++) {
			vals[i] = Double.parseDouble(str[i]);
		}
		
		return vals;
	}
	
	/**
	 * Count lines in the scanner
	 * 
	 * @param scanner
	 * @return
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
	
	/**
	 * 
	 * 
	 * @param values
	 * @return
	 */
	public static double[][] transpose(double[][] values) {
		int originalRows = values.length;
		int originalCols = values[0].length;
		double[][] transpose = new double[originalCols][originalRows];
		
		for (int r = 0; r < originalRows; r++) {
			for (int c = 0; c < originalCols; c++) {
				transpose[c][r] = values[r][c];
			}
		}
		
		return transpose;
	}
	
	public static void writeFile(String path) {
		
	}

}
