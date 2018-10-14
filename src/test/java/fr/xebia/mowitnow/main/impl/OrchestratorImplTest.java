package fr.xebia.mowitnow.main.impl;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class OrchestratorImplTest {

	private static final String fileName = "inputs/input.txt";
	private static final String message = "5 5" + 
			System.getProperty("line.separator") + "1 2 N"
			+ System.getProperty("line.separator") + "GAGAGAGAA" 
			+ System.getProperty("line.separator") + "3 3 E"
			+ System.getProperty("line.separator") + "AADAADADDA";;

	OrchestratorImpl orchestrator;

	@BeforeEach
	public void setUp() throws Exception {
		this.orchestrator = new OrchestratorImpl();
	}

	@Test
	public void testExecuteFromFile() throws Exception {
		this.orchestrator.executeFromFile(new File(getClass().getClassLoader().getResource(fileName).getFile()));
		
		assertEquals("1 3 N", this.orchestrator.getMowers().get(0).getPosition().toString());
		assertEquals("5 1 E", this.orchestrator.getMowers().get(1).getPosition().toString());
	}

	@Test
	public void testExecuteFromText() throws Exception {
		this.orchestrator.executeFromText(message);
		
		assertEquals("1 3 N", this.orchestrator.getMowers().get(0).getPosition().toString());
		assertEquals("5 1 E", this.orchestrator.getMowers().get(1).getPosition().toString());
	}

}
