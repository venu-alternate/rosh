package com.threadweekendmain;

public class EmployeeRunnable implements Runnable {

	@Override
	public void run() {
		FileOperation fileOperation = new FileOperation();
		fileOperation.save(fileFormat);

	}

	public FileFormat getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(FileFormat fileFormat) {
		this.fileFormat = fileFormat;
	}

	FileFormat fileFormat;
}
