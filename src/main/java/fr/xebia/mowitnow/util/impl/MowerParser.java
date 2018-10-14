package fr.xebia.mowitnow.util.impl;

import java.util.Arrays;

import fr.xebia.mowitnow.enums.OrientationEnum;
import fr.xebia.mowitnow.main.Mower;
import fr.xebia.mowitnow.main.impl.MowerImpl;
import fr.xebia.mowitnow.pojo.Position;
import fr.xebia.mowitnow.util.Constantes;
import fr.xebia.mowitnow.util.Parser;

/**
 * Classe d'initialisation d'une tondeuse avec sa position de depart
 *
 */
public class MowerParser implements Parser<String, Mower> {
	
	@Override
	public Mower parse(String input) {
		String [] inputs = input.split(Constantes.SPACE);
		Position position = new Position(Integer.valueOf(inputs[0]),
				Integer.valueOf(inputs[1]),
				getOrientationEnumByDirection(inputs[2]));
		MowerImpl mower = new MowerImpl();
		mower.setPosition(position);
		return mower;
	}

	private OrientationEnum getOrientationEnumByDirection(String direction) {
		return Arrays.stream(OrientationEnum.values()).filter(val -> val.getOrientation().equals(direction)).findFirst().orElseGet(null);
	}
	
}
