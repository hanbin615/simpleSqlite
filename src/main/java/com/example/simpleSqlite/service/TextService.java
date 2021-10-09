package com.example.simpleSqlite.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleSqlite.entity.Text;
import com.example.simpleSqlite.repository.TextRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TextService {

	@Autowired
	TextRepository repository;
	
	@Autowired
	DataSource datasource;
	
	public void dropTable() {
		log.info("dropping table TEXT");
		try(Connection conn = datasource.getConnection();){
			Statement stmt = conn.createStatement();
			stmt.execute("DROP TABLE TEXT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createTableIfNotExists() {
		log.info("creating table TEXT if not exists");
		try(Connection conn = datasource.getConnection();){
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS TEXT("
					+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "CONTENT TEXT)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Text save(String s) {
		return repository.save(new Text(s));
	}
	
	public List<Text> getAll() {
		return repository.findAll();
	}
}
