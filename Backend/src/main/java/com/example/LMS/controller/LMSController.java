package com.example.LMS.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LMS.dto.LMSDTO;
import com.example.LMS.service.LMSService;

@RestController
@RequestMapping("/lms")
public class LMSController {
	private final LMSService lmsService;

	@Autowired
	public LMSController(LMSService lmsService) {
		this.lmsService = lmsService;
	}

	@PostMapping
	public ResponseEntity<LMSDTO> createLMS(@Valid @RequestBody LMSDTO lmsDTO) {
		LMSDTO createdLMS = lmsService.createLMS(lmsDTO);
		return new ResponseEntity<>(createdLMS, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LMSDTO> getLMSById(@PathVariable Long id) {
		LMSDTO lms = lmsService.getLMSById(id);
		return ResponseEntity.ok(lms);
	}

	@GetMapping
	public ResponseEntity<List<LMSDTO>> getAllLMS() {
		List<LMSDTO> lmsList = lmsService.getAllLMS();
		return ResponseEntity.ok(lmsList);
	}

	@GetMapping("/search")
	public ResponseEntity<List<LMSDTO>> searchLMS(@RequestParam(required = false) String title,
			@RequestParam(required = false) LocalDate startDate) {
		List<LMSDTO> lmsList;
		if (title != null) {
			lmsList = lmsService.searchLMSByTitle(title);
		} else {
			lmsList = lmsService.getAllLMS();
		}
		return ResponseEntity.ok(lmsList);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LMSDTO> updateLMS(@PathVariable Long id, @Valid @RequestBody LMSDTO lmsDTO) {
		LMSDTO updatedLMS = lmsService.updateLMS(id, lmsDTO);
		return ResponseEntity.ok(updatedLMS);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteLMS(@PathVariable Long id) {
		boolean isDeleted = lmsService.deleteLMS(id);
		return ResponseEntity.ok(isDeleted);
	}
}
