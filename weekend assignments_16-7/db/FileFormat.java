package com.threadweekendmain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FileFormat {

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	private Timestamp timestamp;
	private int EmpId;
	private List<String> input = new ArrayList<>();
	private String designation;

}
