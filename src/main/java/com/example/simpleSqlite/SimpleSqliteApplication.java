package com.example.simpleSqlite;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.simpleSqlite.entity.Text;
import com.example.simpleSqlite.service.TextService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SimpleSqliteApplication implements CommandLineRunner{
	
	@Autowired
	TextService service;
	
	public static void main(String[] args) {
		log.info("STARTING spring boot application");
		SpringApplication.run(SimpleSqliteApplication.class, args);
		log.info("ENDING   spring boot application");
	}

	/**
	 * launch console after setting up spring
	 */
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
		consoleLoop();
		log.info("Ending: command line runner");
	}
	
	public void printUsage() {
		System.out.println("type 'create' to create the table");
		System.out.println("type 'drop' to drop the table");
		System.out.println("type 'print' to print out all entries");
		System.out.println("type 'end', 'quit' or 'exit' to quit");
		System.out.println("type any other text and it will be added to the table");
	}
	
	public void consoleLoop() {
		log.info("starting consoleLoop");
		printUsage();
		Scanner in = new Scanner(System.in);
		boolean end = false;
		while(!end) {
			String s = in.nextLine();
			try {
				switch(s) {
					case "end":
					case "quit":
					case "exit": 
						System.out.println("byebye");
						in.close();
						end = true;
						break;
					case "print": 
						printAll();
						break;
					case "drop": 
						service.dropTable();
						break;
					case "create":
						service.createTableIfNotExists();
						break;
					default: 
						service.save(s);
						break;
				}
			} catch (RuntimeException e) {
				System.err.println("ERROR");
//				e.printStackTrace();
			}
		}
		log.info("ending ConsoleLoop");
	}

	public void printAll() {
		List<Text> list = service.getAll();
		for(Text t: list)
		System.out.println(t.getId()==null? "null":t.getId().toString() +" | " +t.getContent());
	}
}
