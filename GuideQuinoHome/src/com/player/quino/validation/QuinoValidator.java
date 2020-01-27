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
		int turnCount = 0;
		
        if (input.length() == 0 || !input.matches("[fbrlFBRL].*[0-9,]+"))
            setInputValid(false);
        
        String[] inputWithoutDelimiter = input.split(",");
        
        for(String movement : inputWithoutDelimiter){
        	if(movement.charAt(1) == 0 || turnCount>1) {
				setInputValid(false);
				break;
			}
			if(movement.charAt(0) == 'R' || movement.charAt(0) == 'L') {
				if(Character.getNumericValue(movement.charAt(1)) != 1) {
					setInputValid(false);
					break;
				} 
				turnCount++;
			} 
			else if(turnCount == 1)
				turnCount--;
        }
        return isInputValid();
    }

	public boolean isInputValid() {
		return isInputValid;
	}

	public void setInputValid(boolean isInputValid) {
		this.isInputValid = isInputValid;
	}
}