package com.example.simpleSqlite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TEXT")
@NoArgsConstructor
public class Text {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer id;

	@Column(name = "CONTENT")
	public String content;
	
	public Text(String s) {
		super();
		this.content = s;
	}
}