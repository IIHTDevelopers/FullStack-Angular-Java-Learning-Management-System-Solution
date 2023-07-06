package com.example.LMS.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class LMSDTO {
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	private String title;

	@NotNull
	private String description;

	@NotNull
	private String instructor;

	@NotNull
	private String duration;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	private String syllabus;

	public LMSDTO(Long id, String title, String description, String instructor, String duration, LocalDate startDate,
			LocalDate endDate, String syllabus) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.instructor = instructor;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.syllabus = syllabus;
	}

	public LMSDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

}
