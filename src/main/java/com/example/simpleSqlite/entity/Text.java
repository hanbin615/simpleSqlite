package com.example.simpleSqlite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class Text {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int id;

	@Column(name = "CONTENT")
	public String content;
	
	public Text(String s) {
		super();
		this.content = s;
	}
	
	@Override
	public String toString() {
		return this.content;
	}
}