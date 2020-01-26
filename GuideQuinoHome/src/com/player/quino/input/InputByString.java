package com.player.quino.input;

/**
 * @author Steve Andrew Darwin
 * 
 * This specifies the moves that can be obtained 
 * using an input string
 */
public class InputByString {

	private String[] steps;
	private String input = "F1,R1,B2,L1,B3,R1,F4";
	
	public InputByString() {
		setSteps(new String[100]);
	}
	
	public String[] fetchInputString() {
		String[] removeCommaFromMoves = getInput().split(",");
		setSteps(removeCommaFromMoves);
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