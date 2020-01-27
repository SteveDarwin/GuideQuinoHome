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
	
	/**
     * Validates user input
     *
     * @param   userInput
     * @return  isInputValid
     */
	public boolean validateUserInput(String userInput) {
		String[] inputWithoutDelimiter = userInput.split(",");
		
		//Input length cannot be zero and should contain valid alphanumeric characters with comma as delimiter
        if (userInput.length() == 0 || !userInput.matches("[fbrlFBRL].*[0-9,]+"))
            setInputValid(false);
        else {        
        	setInputValid(validateMovement(inputWithoutDelimiter));
        }
        return isInputValid();
    }
	
	/**
     * Validates game movement
     *
     * @param   inputWithoutDelimiter
     * @return  isInputValid
     */
	public boolean validateMovement(String[] inputWithoutDelimiter) {
		int turnCount = 0;
		for(String movement : inputWithoutDelimiter){
        	//Move cannot have zero steps
			if(Character.getNumericValue(movement.charAt(1)) == 0)
				setInputValid(false);
			else if(movement.charAt(0) == 'R' || movement.charAt(0) == 'L') {
        		turnCount++;
				//Number of steps made by robot while turning cannot be more than one
				if(Integer.parseInt(movement.substring(1)) != 1)
					setInputValid(false);
			}
        	else if(turnCount == 1)
        		//Robot moves Forward or Backward
        		turnCount--;
        	
        	//Robot cannot turn 90 degrees twice in a row
        	if(turnCount>1) {
        		setInputValid(false);
        		break;
        	}
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