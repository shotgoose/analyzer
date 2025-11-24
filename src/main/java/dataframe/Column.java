package dataframe;

public class Column {
	
	/** Column ID */
	private String id;
	
	/** Column display header */
	private String header;
	
	/** Column data */
	private double[] values;
	
	/** Column template code */
	private String templateCode;
	
	/**
	 * Create new column.
	 * 
	 * @param values data in column
	 * @param id id of column
	 * @param header column display header
	 */
	public Column(double[] values, String id, String header) {
		this.values = values;
		this.id = id;
		this.header = header;
		this.templateCode = null;
	}
	
	/**
	 * Create new column with a template code. Should be called only by operations.
	 * 
	 * @param values data in column
	 * @param id id of column
	 * @param header column display header
	 * @param templateCode column template code
	 */
	public Column(double[] values, String id, String header, String templateCode) {
		this(values, id, header);
		this.templateCode = templateCode;
	}
	
	/**
	 * Create new column with no specified display header.
	 * 
	 * @param values data in column
	 * @param id id of column
	 */
	public Column(double[] values, String id) {
		this(values, id, id);
	}
	
	/**
	 * Get value at index.
	 * 
	 * @param index index in the column (0-based)
	 * @return value at index
	 */
	public double get(int index) {
		return values[index];
	}
	
	/**
	 * Get length of column.
	 * 
	 * @return length of column
	 */
	public int length() {
		return values.length;
	}
	
	/**
	 * Fetch column id. 
	 * 
	 * @return id of column
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Fetch column header.
	 * 
	 * @return column header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Fetch template code
	 * 
	 * @return template code
	 */
	public String getTemplateCode() {
		return this.templateCode;
	}
	
	// COLUMN OPERATIONS
	
	/**
	 * Add values of two columns.
	 * 
	 * @param other column to add
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 * @throws IllegalArgumentException if column lengths differ
	 */
	public Column add(Column other, String id, String header) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) + other.get(i);
		}
		
		String templateCode = this.getId() + " add " + other.getId() 
			+ " -id " + id + " -header " + header;
		
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Add a column with no provided header.
	 * 
	 * @param other column to add 
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column add(Column other, String id) {
		return this.add(other, id, id);
	}
	
	/**
	 * Add a column with no provided header or id.
	 * 
	 * @param other column to add
	 * @return resulting column
	 */
	public Column add(Column other) {
		String id = this.getId() + "+" + other.getId();
		return this.add(other, id);
	}
	
	/**
	 * Subtract a column from this column.
	 * 
	 * @param other column to subtract by
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 * @throws IllegalArgumentException if column lengths differ
	 */
	public Column subract(Column other, String id, String header) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) - other.get(i);
		}
		
		String templateCode = this.getId() + " subtract " + other.getId() 
		+ " -id " + id + " -header " + header;
	
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Subtract by column with no provided header.
	 * 
	 * @param other column to subtract 
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column subtract(Column other, String id) {
		return this.subract(other, id, id);
	}
	
	/**
	 * Subtract by column with no provided header or id.
	 * 
	 * @param other column to subtract
	 * @return resulting column
	 */
	public Column subtract(Column other) {
		String id = this.getId() + "-" + other.getId();
		return this.subtract(other, id);
	}
	
	/**
	 * Multiply values of two columns.
	 * 
	 * @param other column to multiply by
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 * @throws IllegalArgumentException if column lengths differ
	 */
	public Column multiply(Column other, String id, String header) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) * other.get(i);
		}
		
		String templateCode = this.getId() + " multiply " + other.getId() 
		+ " -id " + id + " -header " + header;
	
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Multiply by column with no provided header.
	 * 
	 * @param other column to multiply by
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column multiply(Column other, String id) {
		return this.multiply(other, id, id);
	}
	
	/**
	 * Multiply by column with no provided header or id.
	 * 
	 * @param other column to multiply by
	 * @return resulting column
	 */
	public Column multiply(Column other) {
		String id = this.getId() + "*" + other.getId();
		return this.multiply(other, id);
	}
	
	/**
	 * Divide this column by another column.
	 * 
	 * @param other column to divide by
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 * @throws IllegalArgumentException if column lengths differ
	 */
	public Column divide(Column other, String id, String header) {
		if (this.length() != other.length()) {
			throw new IllegalArgumentException("Column size mismatch");
		}
		
		double[] result = new double[this.length()];
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) / other.get(i);
		}
		
		String templateCode = this.getId() + " divide " + other.getId() 
		+ " -id " + id + " -header " + header;
	
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Divide by column with no provided header.
	 * 
	 * @param other column to divide by
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column divide(Column other, String id) {
		return this.divide(other, id, id);
	}
	
	/**
	 * Divide by column with no provided header or id.
	 * 
	 * @param other column to divide by
	 * @return resulting column
	 */
	public Column divide(Column other) {
		String id = this.getId() + "/" + other.getId();
		return this.divide(other, id);
	}
	
	/**
	 * Add constant to all entries of a column.
	 * 
	 * @param number number to add
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 */
	public Column add(Number number, String id, String header) {
		double[] result = new double[this.length()];
		double value = number.doubleValue();
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) + value;
		}
		
		String templateCode = this.getId() + " add " + number 
		+ " -id " + id + " -header " + header;
	
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Add constant with no provided header.
	 * 
	 * @param number number to add
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column add(Number number, String id) {
		return this.add(number, id, id);
	}
	
	/**
	 * Add constant with no provided header or id.
	 * 
	 * @param number number to add
	 * @return resulting column
	 */
	public Column add(Number number) {
		String id = this.getId() + "+" + number;
		return this.add(number, id);
	}
	
	/**
	 * Subtract constant from all entries of a column.
	 * 
	 * @param number number to subtract
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 */
	public Column subtract(Number number, String id, String header) {
		double[] result = new double[this.length()];
		double value = number.doubleValue();
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) - value;
		}
		
		String templateCode = this.getId() + " subtract " + number 
				+ " -id " + id + " -header " + header;
			
				return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Subtract constant with no provided header.
	 * 
	 * @param number number to subtract
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column subtract(Number number, String id) {
		return this.subtract(number, id, id);
	}
	
	/**
	 * Subtract constant with no provided header or id.
	 * 
	 * @param number number to subtract
	 * @return resulting column
	 */
	public Column subtract(Number number) {
		String id = this.getId() + "-" + number;
		return this.subtract(number, id);
	}
	
	/**
	 * Multiply all entries of column by a constant.
	 * 
	 * @param number number to multiply by
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 */
	public Column multiply(Number number, String id, String header) {
		double[] result = new double[this.length()];
		double value = number.doubleValue();
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) * value;
		}
		
		String templateCode = this.getId() + " multiply " + number 
				+ " -id " + id + " -header " + header;
			
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Multiply by constant with no provided header.
	 * 
	 * @param number number to multiply by
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column multiply(Number number, String id) {
		return this.multiply(number, id, id);
	}
	
	/**
	 * Multiply by constant with no provided header or id.
	 * 
	 * @param number number to multiply by
	 * @return resulting column
	 */
	public Column multiply(Number number) {
		String id = this.getId() + "*" + number;
		return this.multiply(number, id);
	}
	
	/**
	 * Divide all entries of column by a constant.
	 * 
	 * @param number number to divide by
	 * @param id id of new column
	 * @param header header of new column
	 * @return resulting column
	 */
	public Column divide(Number number, String id, String header) {
		double[] result = new double[this.length()];
		double value = number.doubleValue();
		
		for (int i = 0; i < this.length(); i++) {
			result[i] = this.get(i) / value;
		}
		
		String templateCode = this.getId() + " divide " + number 
				+ " -id " + id + " -header " + header;
			
		return new Column(result, id, header, templateCode);
	}
	
	/**
	 * Divide by constant with no provided header.
	 * 
	 * @param number number to divide by
	 * @param id id of new column
	 * @return resulting column
	 */
	public Column divide(Number number, String id) {
		return this.divide(number, id, id);
	}
	
	/**
	 * Divide by constant with no provided header or id.
	 * 
	 * @param number number to divide by
	 * @return resulting column
	 */
	public Column divide(Number number) {
		String id = this.getId() + "/" + number;
		return this.divide(number, id);
	}
	
	public Column rollingAverage(int window) {
		// not implemented yet
		return null;
	}
	
	public Column trim(double threshhold) {
		// not implemented yet
		return null;
	}
	
}
