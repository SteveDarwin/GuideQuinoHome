package com.player.quino.input;

/**
 * @author Steve Andrew Darwin
 * 
 * This class specifies the moves that can be obtained 
 * using an input string
 * This class can also be extended further for reading 
 * input from file or scanner
 */
public class QuinoInput {

	private String[] steps;
	private String input = "F150,R1,B29,R1,F25";
	
	public QuinoInput() {
		setSteps(new String[100]);
	}
	
	/**
     * Strip Delimiter from Input
     * and format into string array
     * for simplifying readability of moves
     *
     * @return  steps
     */
	public String[] fetchInputString() {
		String[] inputWithoutDelimiter = getInput().split(",");
		setSteps(inputWithoutDelimiter);
		return getSteps();
	}

	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	private String[] getSteps() {
		return this.steps;
	}

	private void setSteps(String[] steps) {
		this.steps = steps;
	}
}
