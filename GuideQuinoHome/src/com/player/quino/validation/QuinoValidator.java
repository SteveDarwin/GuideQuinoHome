package com.player.quino.validation;

/**
 * @author Steve Andrew Darwin
 *
 * These validations ensure that game rules are followed
 */
public class QuinoValidator {

	private boolean isInputValid;
	
	public QuinoValidator() {
		setInputValid(true);
	}
	
	public boolean validateUserInput(String input) {
        if (input.length() == 0 || !input.matches("[fbrlFBRL1-9,]+"))
            setInputValid(false);
        return isInputValid();
    }

	public boolean isInputValid() {
		return isInputValid;
	}

	public void setInputValid(boolean isInputValid) {
		this.isInputValid = isInputValid;
	}
}