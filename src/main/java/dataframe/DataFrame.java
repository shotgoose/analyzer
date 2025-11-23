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

}
