package dataframe;

import java.util.Arrays;

public class DataFrame {
	
	/** Data grouped by column */
	private Column[] columns;
	
	/** Number of rows in the DataFrame */
	private int rows;
	
	/**
	 * Creates a new DataFrame from an array of columns
	 * 
	 * @param columns array of columns
	 */
	public DataFrame(Column[] columns) {
		if (columns.length > 0) {
			this.rows = columns[0].length();
		}
		else {
			this.rows = 0;
		}
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].length() != rows) {
				throw new IllegalArgumentException("Column dimension mismatch");
			}
		}
		
		this.columns = columns;
	}
	
	/**
	 * Creates a new DataFrame from a 2D array of data with provided headers and id's
	 * 
	 * @param values array of data
	 * @param ids column id's
	 * @param headers column headers
	 */
	public DataFrame(double[][] values, String[] ids, String[] headers) {
		this();
		
		if (values.length == 0) {
		    if (ids.length != 0 || headers.length != 0) {
		        throw new IllegalArgumentException("Dimension mismatch");
		    }
		    // empty DataFrame with 0 columns, 0 rows
		    return;
		}
		if (!(values[0].length == ids.length && ids.length == headers.length)) {
		    throw new IllegalArgumentException("Dimension mismatch");
		}

		double[][] transpose = transpose(values);
		
		for (int i = 0; i < transpose.length; i++) {
			this.append(transpose[i], ids[i], headers[i]);
		}
	}
	
	/**
	 * Creates a new DataFrame from a 2D array of data and provided id's
	 * 
	 * @param values array of data
	 * @param ids column id's
	 */
	public DataFrame(double[][] values, String[] ids) {
		this(values, ids, ids);
	}
	
	/**
	 * Creates a new DataFrame from a 2D array of data
	 * 
	 * @param values array of data
	 */
	public DataFrame(double[][] values) {
		this();
		double[][] transpose = transpose(values);
		
		for (int i = 0; i < transpose.length; i++) {
			this.append(transpose[i]);
		}
	}
	
	/**
	 * Creates empty DataFrame
	 */
	public DataFrame() {
		this(new Column[0]);
	}
	
	/**
	 * Fetch column by id
	 * 
	 * @param id id of column to find
	 * @return column object, null if not found
	 */
	public Column getColumn(String id) {
		
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].getId().equals(id)) {
				return columns[i];
			}
		}
		
		return null;
	}
	
	/**
	 * Fetch column by index
	 * 
	 * @param index
	 * @return column object
	 */
	public Column getColumn (int index) {
		if (index < 0 || index >= this.columns()) {
			return null;
		}
		return columns[index];
	}
	
	/**
	 * Fetch number of rows in DataFrame
	 * 
	 * @return number of rows
	 */
	public int rows() {
		return this.rows;
	}
	
	/**
	 * Fetch number of columns in DataFrame
	 * 
	 * @return number of columns
	 */
	public int columns() {
		return columns.length;
	}
	
	/**
	 * Append a new column to the DataFrame
	 * 
	 * @param column new column
	 */
	public void append(Column column) {
		if (column == null) {
			throw new IllegalArgumentException("Null column");
		}
		if (column.length() != rows && rows != 0) {
			throw new IllegalArgumentException("Invalid number of rows");
		}
		if (getColumn(column.getId()) != null) {
			throw new IllegalArgumentException("A column with that id already exists");
		}
		if (rows == 0) {
			rows = column.length();
		}
		columns = Arrays.copyOf(columns, columns.length + 1);
		columns[columns.length - 1] = column;
	}
	
	/**
	 * Append a new column to the DataFrame with an array of data
	 * 
	 * @param values array of data
	 * @param id id of column
	 * @param header column header
	 */
	public void append(double[] values, String id, String header) {
		this.append(new Column(values, id, header));
	}
	
	/**
	 * Append a new column to the DataFrame by array of data with no header
	 * 
	 * @param values array of data
	 * @param id id of column
	 */
	public void append(double[] values, String id) {
		this.append(values, id, id);
	}
	
	/**
	 * Append a new column to the DataFrame by array of data with no id or header
	 * 
	 * @param values array of data
	 */
	public void append(double[] values) {
		this.append(values, defaultId());
	}
	
	/**
	 * Creates a default id for a column with no specified id
	 * 
	 * @return default id
	 */
	public String defaultId() {
		return "column" + columns.length;
	}
	
	// Static methods
	
	/**
	 * Returns the transpose of a given matrix
	 * 
	 * @param matrix
	 * @return transpose of matrix
	 */
	public static double[][] transpose(double[][] matrix) {
		if (matrix.length == 0) {
			return matrix;
		}
		int originalRows = matrix.length;
		int originalCols = matrix[0].length;
		double[][] transpose = new double[originalCols][originalRows];
		
		for (int r = 0; r < originalRows; r++) {
			for (int c = 0; c < originalCols; c++) {
				transpose[c][r] = matrix[r][c];
			}
		}
		
		return transpose;
	}

}
