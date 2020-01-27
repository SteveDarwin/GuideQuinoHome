package com.player.quino;

import com.player.quino.input.QuinoInput;
import com.player.quino.validation.QuinoValidator;

/**
 * @author Steve Andrew Darwin
 * 
 * This specifies the moves based on user input
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
	
	public int calculateStepsToHome() {
		int direction = 0;
		int stepsToHome = 0;

		for(String name : getQuinoInput().fetchInputString()){
			char move = Character.toUpperCase(name.charAt(0));
			int steps = Integer.parseInt(name.substring(1));
			if (move == 'R') 
				direction = (direction + 1) % 4;
			else if (move == 'L') 
				direction = (4 + direction - 1) % 4;
			else
				setFinalPosition(calculateMovement(direction, move, steps));
		}

		if(getFinalPosition()[0] != getFinalPosition()[1]) {
			stepsToHome = Math.abs(getFinalPosition()[1] - getFinalPosition()[0]);
		} else {
			stepsToHome = Math.abs(getFinalPosition()[1] + getFinalPosition()[0]);
		}
		return stepsToHome;
	}
	
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quino quino = new Quino();
		if(quino.getQuinoValidator().validateUserInput(quino.getQuinoInput().getInput())) {
			quino.setShortestDistance(quino.calculateStepsToHome()); 
			System.out.println("Shortest path = " + quino.getShortestDistance());
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