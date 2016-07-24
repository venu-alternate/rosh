package com.threadweekendmain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Employee {

	private static Scanner in;
	private static int count = 105;

	public static void main(String[] args) {

		while (true) {

			System.out.println("1. Add Employees");

			System.out.println("2.Get All Employee Id's");

			System.out.println("3. Get Employee Information based on Id");

			System.out.println("4. Update Employee information");

			System.out.println("5. A daemon should consolidate all the same transaction files in to one file");

			in = new Scanner(System.in);
			System.out.println("Select option");
			int sel = in.nextInt();
			switch (sel) {
			case 1:
				System.out.println("1. Add Employees");
				System.out.println("if you want to terminate loop enter stop");
				FileFormat fileFormat = new FileFormat();

				count = count + 1;
				fileFormat.setEmpId(count);

				for (int i = 0; i <= 10; i++) {
					in = new Scanner(System.in);
					String a = in.nextLine();

					if ("STOP".equalsIgnoreCase(a)) {
						break;
					} else {
						fileFormat.getInput().add(a);
					}
				}

				EmployeeRunnable employeeRunnable = new EmployeeRunnable();
				employeeRunnable.setFileFormat(fileFormat);
				Thread thread = new Thread(employeeRunnable);
				thread.start();
				break;
			case 2:
				System.out.println("2.Get All Employee Id's");
				FileOperation fileOperation = new FileOperation();
				Set<String> empId = fileOperation.getAllEmpId();
				for (String string : empId) {
					System.out.println(string);

				}

				break;
			case 3:
				System.out.println("3. Get Employee Information based on Id");
				System.out.println("Enter employee Id");
				Scanner in = new Scanner(System.in);
				String value = in.nextLine();

				FileOperation fileOperation2 = new FileOperation();
				Set<String> getAllId = fileOperation2.getEmpId(value);

				BufferedReader bufferedReader = null;

				String sCurrentLine;
				File file = new File("E:\\Threads\\");
				File[] listfiles = file.listFiles();
				for (File empFile : listfiles) {

					try {
						if (empFile.getName().contains(value)) {
							bufferedReader = new BufferedReader(new FileReader(empFile));
							while ((sCurrentLine = bufferedReader.readLine()) != null) {

								System.out.println(sCurrentLine);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (bufferedReader != null) {
							try {
								bufferedReader.close();
							} catch (IOException e) {

								e.printStackTrace();
							}
						}
					}
				}

				break;
			case 4:
				System.out.println("4. Update Employee information");
				System.out.println("Enter the employee id to update employee information");
				Scanner scan = new Scanner(System.in);
				int updateEmpId = scan.nextInt();
				FileFormat fileFormat1 = new FileFormat();
				fileFormat1.setEmpId(updateEmpId);
				for (int i = 0; i <= 10; i++) {
					in = new Scanner(System.in);
					String a = in.nextLine();

					if ("STOP".equalsIgnoreCase(a)) {
						break;
					} else {
						fileFormat1.getInput().add(a);
					}
				}
				EmployeeRunnable employeeRunnable1 = new EmployeeRunnable();
				employeeRunnable1.setFileFormat(fileFormat1);
				Thread thread1 = new Thread(employeeRunnable1);
				thread1.start();

				break;
			case 5:
				System.out.println("5. A daemon should consolidate all the same transaction files in to one file");
				break;
			default:
				System.out.println("invalid option");
			}
		}

	}

}
