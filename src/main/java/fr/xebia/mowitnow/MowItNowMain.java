package fr.xebia.mowitnow;

import java.io.File;
import java.io.IOException;

import fr.xebia.mowitnow.exceptions.MowItNowException;
import fr.xebia.mowitnow.main.Orchestrator;
import fr.xebia.mowitnow.main.impl.OrchestratorImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * MonItNow Main class
 *
 */
@Slf4j
public class MowItNowMain 
{
    public static void main( String[] args )
    {
        Orchestrator orchestrator = new OrchestratorImpl();
        if(args.length<=0){
        	log.error("nombre d'argument du programme insufisant : il faut preciser le nom du fichier de parametrage");
        	System.exit(1);
        }
        
        try {
			orchestrator.executeFromFile(new File(args[0]));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} catch (MowItNowException e) {
			log.error(e.getMessage(), e);
		}
    }
}
