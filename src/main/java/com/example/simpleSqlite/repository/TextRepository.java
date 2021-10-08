package com.example.simpleSqlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleSqlite.entity.Text;

@Repository
public interface TextRepository extends JpaRepository<Text, Integer>{

}
