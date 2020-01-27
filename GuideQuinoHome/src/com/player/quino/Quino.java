package com.player.quino;

import com.player.quino.input.QuinoInput;
import com.player.quino.validation.QuinoValidator;

/**
 * @author Steve Andrew Darwin
 * 
 * This class specifies the game play based on user input
 * and provides the shortest way to guide Quino home
 */
public class Quino {

	private QuinoValidator quinoValidator;
	private QuinoInput quinoInput;
	
	private int shortestDistance;
	private int x;
	private int y;
	private int[] position;
	private int[] finalPosition;
	
	public Quino() {
		setQuinoValidator(new QuinoValidator());
		setQuinoInput(new QuinoInput());
		setShortestDistance(0);
		x = 0;
		y = 0;
		setPosition(new int[2]);
		setFinalPosition(new int[2]);
	}
	
	/**
     * Calculate shortest distance to reach home
     *
     * @return  stepsToHome
     */
	public int calculateStepsToHome() {
		int direction = 0;
		int stepsToHome = 0;

		for(String userInput : getQuinoInput().fetchInputString()){
			char move = Character.toUpperCase(userInput.charAt(0));
			int steps = Integer.parseInt(userInput.substring(1));
			if (move == 'R')
				//Move Right
				direction = (direction + 1) % 4;
			else if (move == 'L') 
				//Move Left
				direction = (4 + direction - 1) % 4;
			else
				//Move Forward or Backward - specified as move 'F' and 'B' respectively
				setFinalPosition(calculateMovement(direction, move, steps));
		}

		if(getFinalPosition()[0] != getFinalPosition()[1])
			stepsToHome = Math.abs(getFinalPosition()[1] - getFinalPosition()[0]);
		else
			stepsToHome = Math.abs(getFinalPosition()[1] + getFinalPosition()[0]);
		return stepsToHome;
	}
	
	/**
     * Calculate robot movement based on user input 
     *
     * @param   direction, move, steps
     * @return  currentPosition
     */
	public int[] calculateMovement(int direction, char move, int steps) {
		switch(direction) {
			case 0:
				if (move == 'F')
					y += steps;
				else
					y -= steps;
				break;
			case 1:
				if (move == 'F')
					x += steps;
				else
					x -= steps; 
				break;
			case 2:
				if (move == 'F')
					y -= steps;
				else
					y += steps;
				break;
			default:
				if (move == 'F')
					x -= steps;
				else
					x += steps;
				break;
		}
		
		getPosition()[0] = x; 
		getPosition()[1] = y;
		
		return getPosition();
	}
	
	public static void main(String[] args) {
		Quino quino = new Quino();
		//Validating the user input
		if(quino.getQuinoValidator().validateUserInput(quino.getQuinoInput().getInput())) {
			//Calculating the shortest distance to reach starting point or home
			quino.setShortestDistance(quino.calculateStepsToHome()); 
			/*Note: As best practice, Loggers should be used in place of System.out with error codes.
			 * Logger can be customized to show the output directly without the time stamp. 
			 * This can be implemented by extending the log4j appender for INFO level.
			*/
			System.out.println(quino.getShortestDistance());
		}
		else
			System.out.println("Invalid Input");
	}

	public QuinoValidator getQuinoValidator() {
		return this.quinoValidator;
	}

	public void setQuinoValidator(QuinoValidator quinoValidator) {
		this.quinoValidator = quinoValidator;
	}

	private QuinoInput getQuinoInput() {
		return this.quinoInput;
	}

	private void setQuinoInput(QuinoInput quinoInput) {
		this.quinoInput = quinoInput;
	}

	private int getShortestDistance() {
		return this.shortestDistance;
	}

	private void setShortestDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	public int[] getPosition() {
		return this.position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public int[] getFinalPosition() {
		return this.finalPosition;
	}

	public void setFinalPosition(int[] finalPosition) {
		this.finalPosition = finalPosition;
	}
}