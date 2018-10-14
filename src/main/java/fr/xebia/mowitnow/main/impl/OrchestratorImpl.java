package fr.xebia.mowitnow.main.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import fr.xebia.mowitnow.exceptions.MowItNowException;
import fr.xebia.mowitnow.main.Orchestrator;
import fr.xebia.mowitnow.pojo.Position;
import fr.xebia.mowitnow.util.Constantes;
import fr.xebia.mowitnow.util.impl.InstructionParser;
import fr.xebia.mowitnow.util.impl.MowerParser;
import lombok.Getter;
import lombok.NonNull;

/**
 * Orchestrareur des tondeuses => Initialise les tondeuses avec leurs
 * instructions et lance l'exécution
 * 
 * @author mcm17
 *
 */
public class OrchestratorImpl implements Orchestrator {
	
	@Getter
	private List<MowerImpl> mowers = new ArrayList<>();

	private void execute(@NonNull List<String> messages) throws MowItNowException {
		if(messages.size() <=2 ){
			 throw new MowItNowException("Parametrage incorrect : nombre de parametre insuffisant");
		}
		
		Iterator<String> messagesLines = messages.iterator();
		String firstLine = messagesLines.next();
		String[] maxSizePelouse = firstLine.split(Constantes.SPACE);
		//Position ma pour determiner les périmètre de la pelouse
		Position maxPosition;
		try{
			maxPosition = new Position(Integer.parseInt(maxSizePelouse[0]), Integer.parseInt(maxSizePelouse[1]),
					null);
 		} catch (NumberFormatException nfe){
 			throw new MowItNowException("Parametrage incorrect : la premiere ligne doit etre sous la forme \"[nombre] [nombre]\"");
 		}
		

		MowerParser mowerParser = new MowerParser();
		InstructionParser instructionParser = new InstructionParser();
		int i = 1;
		while (messagesLines.hasNext()) {
			MowerImpl mower = (MowerImpl) mowerParser.parse(messagesLines.next());
			mower.setId(i);
			mower.setInstructions(instructionParser.parse(messagesLines.next()));
			mower.setMaxPosition(maxPosition);

			mower.execution();
			i++;
			
			mowers.add(mower);
		}

	}

	/**
	 * {@inheritDoc}
	 * @throws MowItNowException 
	 */
	@Override
	public void executeFromFile(@NonNull File file) throws IOException, MowItNowException {
		execute(Files.lines(Paths.get(file.getPath())).collect(Collectors.toList()));

	}

	/**
	 * {@inheritDoc}
	 * @throws MowItNowException 
	 */
	@Override
	public void executeFromText(@NonNull String message) throws MowItNowException {
		execute(Arrays.asList(message.split(Constantes.LINE_SEPERATOR)));

	}

}
