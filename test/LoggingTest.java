package test;


import java.io.*;
import java.io.IOException; 
import java.util.logging.Logger; 
import java.util.logging.Level;
import java.util.logging.*; 

public class LoggingTest {
	private final static Logger logger =  Logger.getLogger(LoggingTest.class.getName()); 
    
	// Main method to run the logging
    public static void main(String[] args) {
//        LOGGER.log(Level.INFO, "My first Log Message");
        logger.info("1 Moving elevator {} to floor {}");
        logger.warning("2 Moving elevator {} to floor {}");
        logger.severe("3 Moving elevator {} to floor {}");
        logger.fine("4 Moving elevator {} to floor {}");
    }
}
