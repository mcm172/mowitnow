package fr.xebia.mowitnow.main.impl;

import java.util.Queue;

import fr.xebia.mowitnow.enums.InstructionEnum;
import fr.xebia.mowitnow.main.Mower;
import fr.xebia.mowitnow.pojo.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de representation d'une tondeuse
 * @author mcm17
 *
 */
@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MowerImpl implements Mower{
	
	/**
	 * Identifiant de la tondeuse
	 */
	private int id;
	
	/**
	 * Position de depart de la tondeuse
	 */
	private Position position;
	
	/**
	 * Position pour determiner le perimetre de la pelouse 
	 */
	private Position maxPosition;
	
	/**
	 * Suite d'instruction a executer par la tondeuse
	 */
	private Queue<InstructionEnum> instructions;

	/**
	 * {@inheritDoc}
	 */
	public void pivoterADroite() {
		this.getPosition().setOrientation(this.getPosition().getOrientation().getRight());
	}

	/**
	 * {@inheritDoc}
	 */
	public void pivoterAGauche() {
		this.getPosition().setOrientation(this.getPosition().getOrientation().getLeft());
	}

	/**
	 * {@inheritDoc}
	 */
	public void avancer() {
		switch(getPosition().getOrientation()){
			case EAST:
				this.getPosition().setX(this.getPosition().getX()+1 <= getMaxPosition().getX()? this.getPosition().getX()+1 : this.getPosition().getX());
				break;
			case NORTH:
				this.getPosition().setY(this.getPosition().getY()+1 <= getMaxPosition().getY()? this.getPosition().getY()+1 : this.getPosition().getY());
				break;
			case SOUTH:
				this.getPosition().setY(this.getPosition().getY()-1 >= 0? this.getPosition().getY()-1 : this.getPosition().getY());
				break;
			case WEST:
				this.getPosition().setX(this.getPosition().getX()-1 >= 0? this.getPosition().getX()-1 : this.getPosition().getX());
				break;
			default:
				break;
		
		}
		if(log.isDebugEnabled()){
			log.debug("Tondeuse : {} => Position : {} {} {}", getId(), getPosition().getX(), getPosition().getY(), getPosition().getOrientation().getOrientation());
		}
		
		
	}
	
	public void execution(){
		instructions.forEach(instruction -> instruction.apply(this));
		log.info("Tondeuse : {} => Position : {} {} {}", getId(), getPosition().getX(), getPosition().getY(), getPosition().getOrientation().getOrientation());
		
	}
}
