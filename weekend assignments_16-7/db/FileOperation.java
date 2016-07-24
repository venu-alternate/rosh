package com.threadweekendmain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FileOperation {

	public void save(FileFormat fileFormat) {
		FileWriter fop = null;
		File file = new File("E:\\Threads\\" + UUID.randomUUID().toString()+fileFormat.getEmpId()+ ".txt");

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fop = new FileWriter(file, true);
			fileFormat.setTimestamp(new Timestamp(new Date().getTime()));
			fop.write(fileFormat.getEmpId() + ":" + fileFormat.getTimestamp());
			for (String s : fileFormat.getInput()) {
				fop.write(System.lineSeparator());
				fop.write(s);
			}
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<FileFormat> getFile(String empId) {
		List<FileFormat> fileFormats = new ArrayList<>();
		File file = new File("E:\\Threads");
		File[] listfiles = file.listFiles();
		for (File empFile : listfiles) {
			BufferedReader brTest = null;
			try {
				brTest = new BufferedReader(new FileReader(empFile));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			String text = null;
			try {
				text = brTest.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}

			String[] strArray = text.split(":");
			FileFormat fileFormat = new FileFormat();
			String variable = strArray[0];
			String[] variable2 = variable.split(":");
			fileFormat.setEmpId(Integer.parseInt(variable2[0]));

			if (empId != null) {
				if (empId.equalsIgnoreCase(fileFormat.getEmpId() + "")) {
					fileFormats.add(fileFormat);
				}
			} else {
				fileFormats.add(fileFormat);
			}

		}
		return fileFormats;
	}

	public Set<String> getAllEmpId() {
		List<FileFormat> allFile = getFile(null);
		Set<String> empId = new HashSet<>();
		for (FileFormat fileFormat : allFile) {
			empId.add(fileFormat.getEmpId() + " ");
		}
		return empId;
	}

	public Set<String> getEmpId(String empId1) {
		List<FileFormat> allFile = getFile(empId1);
		Set<String> empId11 = new HashSet<>();
		for (FileFormat fileFormat : allFile) {
			empId11.add(fileFormat.getEmpId() + " ");
		}
		return empId11;
	}

}