package dataframe;

public class DataFrame {
	
	/** Data grouped by column */
	private Column[] columns;
	
	/**
	 * Creates a new DataFrame
	 */
	public DataFrame(String[] headers, double[][] data) {
		
	}
	
	/**
	 * Fetch array of data in a column
	 * 
	 * @param header
	 * @return all data in column
	 */
	private Column getColumn(String header) {
		
		int index = findColumn(header);
		
		return data[index];
	}

}
