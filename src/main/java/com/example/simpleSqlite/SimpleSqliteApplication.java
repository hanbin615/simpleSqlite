package com.example.simpleSqlite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSqliteApplication implements CommandLineRunner{
	
	private static Logger log = LoggerFactory.getLogger(SimpleSqliteApplication.class);

	@Value( "${properties-test}" )
	private String properties_test;
	
	public static void main(String[] args) {
		log.info("STARTING spring boot application");
		SpringApplication.run(SimpleSqliteApplication.class, args);
		log.info("ENDING   spring boot application");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Executing: command line runner");
		
		if(args.length == 0) {
			log.info("no args");
		} else {
			int i = 1;
			for (String s: args) {
				log.info("args[{}]: {}", i++, s);
			}
		}
		checkProperties();
	}
	
	public void checkProperties() {
		log.info("checking properties ...");
		if (properties_test == null) {
			log.info("properties = null");
		} else {
			log.info("properties = {}", properties_test);
		}
	}

}
