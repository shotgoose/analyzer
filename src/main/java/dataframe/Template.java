package dataframe;

public class Template {

	/** Array containing strings of DataFrame instructions */
	private String[] instructions;
	
	/**
	 * Creates a new Template based on hard coded instructions
	 * 
	 * @param instructions array of instructions
	 */
	public Template(String[] instructions) {
		this.instructions = instructions;
	}
	
	/**
	 * Creates a new Template based on a DataFrame
	 * 
	 * @param dataframe DataFrame to base template on
	 */
	public Template(DataFrame dataframe) {
		String[] rawInstructions = new String[dataframe.columns()];
		int total = 0;
		for (int i = 0; i < dataframe.columns(); i++) {
			String line = dataframe.getColumn(i).getTemplateCode();
			if (line != null) {
				total++;
			}
			rawInstructions[i] = line;
		}
		
		String[] instructions = new String[total];
		int lines = 0;
		for (int i = 0; lines <= total; i++) {
			if (rawInstructions[i] != null) {
				instructions[lines] = rawInstructions[i];
				lines++;
			}
		}
		
		this.instructions = instructions;
	}
	
	/** 
	 * Execute a template on a DataFrame 
	 * 
	 * @param dataframe DataFrame to execute on
	 */
	public void executeTemplate(DataFrame dataframe) {
		
	}
	
	public static boolean isValid(String instruction) {
		return true;
	}
	
}
