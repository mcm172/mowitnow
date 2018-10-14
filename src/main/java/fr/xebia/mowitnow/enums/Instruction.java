package fr.xebia.mowitnow.enums;

import fr.xebia.mowitnow.main.Mower;

public interface Instruction {
	public void apply(Mower mower);
}
