package dataframe;

public class Column {
	
	/** Column data */
	private double[] values;
	
	/**
	 * Create new column
	 * 
	 * @param values
	 */
	public Column(double[] values) {
		this.values = values;
	}
	
	/**
	 * Get value at index
	 * 
	 * @param index
	 * @return value at index
	 */
	public double get(int index) {
		return values[index];
	}
	
	/**
	 * Get length of column
	 * 
	 * @return length of column
	 */
	public int length() {
		return values.length;
	}
	
	/**
	 * Add values of two columns
	 * 
	 * @param column to add
	 * @return resulting column
	 */
	public Column add(Column other) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) + other.get(i);
		}
		
		return new Column(result);
	}
	
	/**
	 * Subtract a column from this column
	 * 
	 * @param column to subtract from this column
	 * @return resulting column
	 */
	public Column subract(Column other) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) - other.get(i);
		}
		
		return new Column(result);
	}
	
	/**
	 * Multiply values of two columns
	 * 
	 * @param column to multiply
	 * @return resulting column
	 */
	public Column multiply(Column other) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) * other.get(i);
		}
		
		return new Column(result);
	}
	
	/**
	 * Divide this column by another column
	 * 
	 * @param column to divide by
	 * @return resulting column
	 */
	public Column divide(Column other) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) / other.get(i);
		}
		
		return new Column(result);
	}
	
	
}
