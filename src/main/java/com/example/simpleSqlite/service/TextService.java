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

@Service
public class TextService {

	@Autowired
	TextRepository repository;
	
	@Autowired
	DataSource datasource;
/*	
	public void execute(String s) {
		try(Connection conn = datasource.getConnection();){
			Statement stmt = conn.createStatement();
			stmt.execute(s);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/	
	public Text save(String s) {
		return repository.save(new Text(s));
	}
	
	public List<Text> getAll() {
		return repository.findAll();
	}
}
