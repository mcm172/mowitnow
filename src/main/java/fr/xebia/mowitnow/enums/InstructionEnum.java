package fr.xebia.mowitnow.enums;

import fr.xebia.mowitnow.main.Mower;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Enumération des instructions possibles de contrôle de la tondeuse
 * @author mcm17
 *
 */
@AllArgsConstructor
public enum InstructionEnum implements Instruction {
	
	A_DROITE('D'){
		@Override
		public void apply(Mower mower) {
			mower.pivoterADroite();
			
		}
	},
	A_GAUCHE('G'){
		@Override
		public void apply(Mower mower) {
			mower.pivoterAGauche();
			
		}
	},
	AVANCER('A'){
		@Override
		public void apply(Mower mower) {
			mower.avancer();
			
		}
	};
	
	@Getter
	char code;
	
}
