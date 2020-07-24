package com.montran.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamUtil1 {

	private OutputStream outputStream;

	//public void writeDataIntoFile(File file, int employeeId, String name, double salary) {
	public void writeDataIntoFile(File file, byte[] data) {
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(data);
			/*outputStream.write(employeeId);
			outputStream.write(name);
			outputStream.write(salary);*/
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException :: ");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException");
			System.out.println(e.getMessage());
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				System.out.println("IOException");
				System.out.println(e.getMessage());
			}
		}

	}
}
