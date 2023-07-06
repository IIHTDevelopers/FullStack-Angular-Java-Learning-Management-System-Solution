package com.example.LMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LMS.entity.LMS;

public interface LMSDAO extends JpaRepository<LMS, Long> {

	// Custom methods for searching by title and start date
	List<LMS> findByTitleContainingIgnoreCase(String title);

}
