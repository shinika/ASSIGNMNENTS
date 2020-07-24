package com.montran.main;


import java.io.File;
import java.util.Scanner;

import com.montran.util.FileOutputStreamUtil1;
import com.montran.util.FileInputStreamUtil;
import com.montran.util.FileInputStreamUtil1;
import com.montran.util.FileOutputStreamUtil;

public class FileIOStream {

	public static void main(String[] args) {
		
		/*Scanner scanner = new Scanner(System.in);
		FileInputStreamUtil1 util = new FileInputStreamUtil1();
		String filePath;
		File file;
		byte[] fileData;

		System.out.println("Enter path of file");
		filePath = scanner.nextLine();
		file = new File(filePath);

		fileData = util.getFileData(file);

		System.out.println("Data From File");
		System.out.println("EmpId Ename Salary");
		for (byte b : fileData) {
			System.out.print((char) b);
		}
		scanner.close();
		*/
		
		Scanner scanner = new Scanner(System.in);
		FileOutputStreamUtil1 util = new FileOutputStreamUtil1();
		FileInputStreamUtil1 util1 = new FileInputStreamUtil1();
		

		byte[] fileData;
		String filePath;
		String data;
		File file;

		System.out.println("Enter Path");
		filePath = scanner.next();
		file = new File(filePath);
		
		/*
		scanner.nextLine();
		System.out.println("Enter Data for file");
		data = scanner.nextLine();
		*/
		
		System.out.println("Enter EmployeeId");
		data = scanner.nextLine();
		data+= scanner.nextLine();
		data+=" ";
		System.out.println("Enter EmployeeName");
		data += scanner.nextLine();
		data+=" ";
		System.out.println("Enter EmployeeSalary");
		data += scanner.nextLine();
		data+=" ";
		
		
		util.writeDataIntoFile(file, data.getBytes());

		System.out.println("Please check your file !!");
		
		

		System.out.println("Enter path of file for reading data");
		filePath = scanner.nextLine();
		file = new File(filePath);

		fileData = util1.getFileData(file);

		System.out.println("Data From File");
		System.out.println("EmpId Ename Salary");
		for (byte b : fileData) {
			System.out.print((char) b);
		}
		scanner.close();
		
		
	}

}
