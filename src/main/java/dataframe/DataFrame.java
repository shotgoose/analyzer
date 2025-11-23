package dataframe;

import java.util.Arrays;

public class DataFrame {
	
	/** Column headers */
	private String[] headers;
	
	/** Data grouped by column */
	private Column[] columns;
	
	/**
	 * Creates a new DataFrame
	 */
	public DataFrame(String[] headers, Column[] columns) {
		if (headers.length != columns.length) {
			throw new IllegalArgumentException("Array size mismatch");
		}

		this.headers = headers;
		this.columns = columns;
		
	}
	
	/**
	 * Creates a new DataFrame from an array
	 * 
	 * @param headers column headers
	 * @param values array of values
	 */
	public DataFrame(String[] headers, double[][] values) {
		int originalRows = values.length;
		int originalCols = values[0].length;
		double[][] transpose = new double[originalCols][originalRows];
		
		for (int r = 0; r < originalRows; r++) {
			for (int c = 0; c < originalCols; c++) {
				transpose[c][r] = values[r][c];
			}
		}
		
		Column[] cols = new Column[transpose.length];
		for (int i = 0; i < transpose.length; i++) {
			cols[i] = new Column(transpose[i]);
		}
		
		this.headers = headers;
		this.columns = cols;
	}
	
	/**
	 * Creates empty DataFrame
	 */
	public DataFrame() {
		this(new String[0], new Column[0]);
	}
	
	/**
	 * Fetch column by header
	 * 
	 * @param header header of column to find
	 * @return column object, null if not found
	 */
	public Column getColumn(String header) {
		
		for (int i = 0; i < columns.length; i++) {
			if (headers[i].equals(header)) {
				return columns[i];
			}
		}
		
		return null;
	}
	
	/**
	 * Append a new column to the DataFrame
	 * 
	 * @param header new header
	 * @param column new column
	 */
	public void append(String header, Column column) {
		
		headers = Arrays.copyOf(headers, headers.length + 1);
		headers[headers.length - 1] = header;
		columns = Arrays.copyOf(columns, columns.length + 1);
		columns[columns.length - 1] = column;
		
	}
	
	public DataFrame trim(String columnHeader, double threshhold) {
		
	}

}
