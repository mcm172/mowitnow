package fr.xebia.mowitnow.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MowItNowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4678418932172971246L;

	public MowItNowException(String message, Throwable e){
		super(message, e);
	}
	
	public MowItNowException(String message){
		super(message);
	}
}
