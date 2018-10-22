package fr.xebia.mowitnow.main.impl;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fr.xebia.mowitnow.enums.InstructionEnum;
import fr.xebia.mowitnow.enums.OrientationEnum;
import fr.xebia.mowitnow.pojo.Position;

@RunWith(JUnitPlatform.class)
public class MowerImplTest {

	@Test
	public void testPivoterADroite() throws Exception {
		MowerImpl mower = getMower();
		mower.pivoterADroite();
		
		Assertions.assertEquals(new Position(0, 0, OrientationEnum.EAST), mower.getPosition());
	}

	@Test
	public void testPivoterAGauche() throws Exception {
		MowerImpl mower = getMower();
		mower.pivoterAGauche();
		
		Assertions.assertEquals(new Position(0, 0, OrientationEnum.WEST), mower.getPosition());
	}

	@Test
	public void testAvancer() throws Exception {
		MowerImpl mower = getMower();
		mower.avancer();
		
		Assertions.assertEquals(new Position(0, 1, OrientationEnum.NORTH), mower.getPosition());
	}

	@Test
	public void testExecution() throws Exception {
		MowerImpl mower = getMower();
		mower.setInstructions(getInstructions());
		mower.execution();
		
		Assertions.assertEquals(new Position(1, 0, OrientationEnum.NORTH), mower.getPosition());
	}

	private MowerImpl getMower() {
		
		return new MowerImpl(1, new Position(0, 0, OrientationEnum.NORTH), new Position(2, 2, OrientationEnum.NORTH), null);
	}
	
	private Queue<InstructionEnum> getInstructions() {
		Queue<InstructionEnum> instructions = new LinkedList<>();
		instructions.add(InstructionEnum.A_DROITE);
		instructions.add(InstructionEnum.AVANCER);
		instructions.add(InstructionEnum.A_GAUCHE);
		
		return instructions;
	}
}
