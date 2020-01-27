package com.player.quino.input;

/**
 * @author Steve Andrew Darwin
 * 
 * This specifies the moves that can be obtained 
 * using an input string
 * 
 */
public class QuinoInput {

	private String[] steps;
	private String input = "F1,R1,B3";
	
	public QuinoInput() {
		setSteps(new String[100]);
	}
	
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