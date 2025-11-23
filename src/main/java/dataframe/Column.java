package dataframe;

public class Column {
	
	/** Column header */
	private String header;
	
	/** Column data */
	private double[] data;
	
	public Column(String header, double[] data) {
		this.header = header;
		this.data = data;
	}
	
	public String getHeader() {
		return this.header;
	}
	
	public double getEntry(int index) {
		return data[index - 1];
	}
	
	public Column multiply(Column other) {
		
	}
	
	public Column divide(Column other) {
	
	}
	
	public Column add(Column other) {
		
	}
	
	public Column subract(Column other) {
	
	}
	}
	
}
