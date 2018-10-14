package fr.xebia.mowitnow.util.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import fr.xebia.mowitnow.enums.InstructionEnum;
import fr.xebia.mowitnow.util.Parser;

/**
 * Classe qui construit la suite d'instructions a executer par une tondeuse
 * 
 * @author mcm17
 *
 */
public class InstructionParser implements Parser<String, Queue<InstructionEnum>> {

	@Override
	public Queue<InstructionEnum> parse(String input) {
		Queue<InstructionEnum> instructions = new LinkedList<InstructionEnum>();
		for (char instruction : input.toCharArray()) {
			instructions.add(getInstructionEnumBycode(instruction));
		}
		return instructions;
	}

	private InstructionEnum getInstructionEnumBycode(char code) {
		return Arrays.stream(InstructionEnum.values()).filter(val -> val.getCode() == code).findFirst().orElseGet(null);
	}

}
