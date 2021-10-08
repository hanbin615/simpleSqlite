package com.example.simpleSqlite;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.simpleSqlite.entity.Text;
import com.example.simpleSqlite.service.TextService;

@SpringBootApplication
public class SimpleSqliteApplication implements CommandLineRunner{
	
	private static Logger log = LoggerFactory.getLogger(SimpleSqliteApplication.class);

	@Value( "${properties-test}" )
	private String properties_test;
	
	@Autowired
	TextService service;
	
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
//		checkProperties();
		loop();
		log.info("Ending: command line runner");
	}
	
	public void loop() {
		log.info("starting loop");
		Scanner in = new Scanner(System.in);
		boolean end = false;
		while(!end) {
			String s = in.nextLine();
			switch(s) {
//				case "":
				case "exit()": {
					System.out.println("byebye");
					in.close();
					end = true;
				}
				default: {
					service.save(s);
					printAll();
				}
			}
		}
		log.info("ending loop");
	}
	
	public void checkProperties() {
		log.info("checking properties ...");
		if (properties_test == null) {
			log.info("properties = null");
		} else {
			log.info("properties = {}", properties_test);
		}
		log.info("checking properties COMPLETED");		
	}

	public void printAll() {
		List<Text> list = service.getAll();
		for(Text t: list)
		System.out.println(t);
	}
}
