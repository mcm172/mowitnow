package fr.xebia.mowitnow.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Enumeration des orientations selon la notation cardinale anglaise (N,E,W,S)
 * @author mcm17
 *
 */
@AllArgsConstructor
public enum OrientationEnum {
	NORTH(0, "N", 1, 3),
	EAST(1, "E", 2, 0),
	SOUTH(2, "S", 3, 1),
	WEST(3, "W", 0, 2);
	
	/**
	 * Abscisse
	 */
	@Getter
	private int code;
	
	/**
	 * Code de l'orientation
	 */
	@Getter
	private String orientation;
	
	/**
	 * Orientation a droite
	 */
	@Getter
	private int rightOrientationCode;
	
	/**
	 * Orientation a gauche
	 */
	@Getter
	private int leftOrientationCode;
	
	/**
	 * Renvoie l'orientation a gauche
	 */
	public OrientationEnum getLeft() {
		return Arrays.stream(values()).filter(val -> val.getCode() == this.getLeftOrientationCode()).findFirst().orElseGet(null);
	}
	
	/**
	 * Renvoie l'orientation a droite
	 */
	public OrientationEnum getRight() {
		return Arrays.stream(values()).filter(val -> val.getCode() == this.getRightOrientationCode()).findFirst().orElseGet(null);
	}
	
	
}
