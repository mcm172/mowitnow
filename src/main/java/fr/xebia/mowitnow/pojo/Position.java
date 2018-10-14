package fr.xebia.mowitnow.pojo;

import fr.xebia.mowitnow.enums.OrientationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {
	private int x;
	
	private int y;
	
	private OrientationEnum orientation;
	
	@Override
	public String toString(){
		return x + " " + y + " " + orientation.getOrientation();
		
	}
}
