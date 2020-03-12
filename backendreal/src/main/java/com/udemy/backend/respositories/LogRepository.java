package com.udemy.backend.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backend.entity.LogApp;

/**
 * The Interface LogRepository.
 */
@Repository("logRepository")
public interface LogRepository extends JpaRepository<LogApp, Serializable>{

	
	
}
