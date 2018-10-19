package fr.xebia.mowitnow.util.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fr.xebia.mowitnow.enums.OrientationEnum;
import fr.xebia.mowitnow.main.Mower;
import fr.xebia.mowitnow.main.impl.MowerImpl;
import fr.xebia.mowitnow.pojo.Position;

@RunWith(JUnitPlatform.class)
public class MowerParserTest {
	private static final String mowerDefinition = "1 2 N";
	
	@Test
	public void testParse() throws Exception {
		Mower mower = new MowerParser().parse(mowerDefinition);
		
		Assertions.assertEquals(this.getExpected(), mower);
	}
	
	private Mower getExpected() {
		MowerImpl mower = new MowerImpl();
		
		Position position = new Position(1, 2, OrientationEnum.NORTH);
		
		mower.setPosition(position);
		
		return mower;
	}
}
