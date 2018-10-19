package fr.xebia.mowitnow.util.impl;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Assertions;

import fr.xebia.mowitnow.enums.InstructionEnum;

@RunWith(JUnitPlatform.class)
public class InstructionParserTest {

	private String instructions = "GADAG";
	
	@Test
	public void testParse() throws Exception {
		Queue<InstructionEnum> results = new InstructionParser().parse(instructions);
		Assertions.assertEquals(this.getExpected(), results);
		
	}

	private Queue<InstructionEnum> getExpected() {
		Queue<InstructionEnum> expected = new LinkedList<InstructionEnum>();
		expected.add(InstructionEnum.A_GAUCHE);
		expected.add(InstructionEnum.AVANCER);
		expected.add(InstructionEnum.A_DROITE);
		expected.add(InstructionEnum.AVANCER);
		expected.add(InstructionEnum.A_GAUCHE);
		return expected;
	}

}
