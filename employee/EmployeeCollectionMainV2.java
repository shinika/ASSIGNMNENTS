package com.montran.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtilV2;

public class EmployeeCollectionMainV2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeCollectionUtilV2 util = new EmployeeCollectionUtilV2(10);
		List<Employee> employeeList ;
	    //Employee employees[]= null;
		Employee employee;
		int employeeId;
		String name;
		double salary;
		int employeeChoice;
		boolean result;
		int numberOfemployeeList;
		String continueChoice;
		

		do {
			employeeList = util.getAllemployees();
			for (Employee employeeTemp : employeeList) {
				if (employeeTemp != null) {
					System.out.println(employeeTemp.getEmployeeId() + "\t" + employeeTemp.getName() + "\t" + employeeTemp.getSalary());
				}
			}
			System.out.println("Menu");
			System.out.println("1. Add Single employee	");
			System.out.println("2. Add Multiple employeeList");
			System.out.println("3. Update Existing employee");
			System.out.println("4. Delete Existing employee");
			System.out.println("5. Print Single employee Details");
			System.out.println("6. Exit");

			System.out.println("Enter your choice");
			employeeChoice = scanner.nextInt();
			switch (employeeChoice) {
			case 1:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Name");
				name = scanner.nextLine();

				System.out.println("Enter Salary");
				salary = scanner.nextDouble();

				employee = new Employee(employeeId, name, salary);

				result = util.addNewEmployee(employee);
				if (result)
					System.out.println("employee is added successfully !!");
				else
					System.out.println("Fail to add employee");
				break;
			case 2:
				System.out.println("How many employees do you want to add ?");
				numberOfemployeeList = scanner.nextInt();
				if (numberOfemployeeList < (util.getMaxIndex() - util.getNextIndex())) {
					employeeList = new ArrayList<Employee>(numberOfemployeeList);
					for (int i = 0; i < numberOfemployeeList; i++) {
						System.out.println("Enter employeeId");
						employeeId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("employee Name");
						name = scanner.nextLine();
						System.out.println("employee Salary");
						salary = scanner.nextDouble();
						
						employee = new Employee(employeeId, name, salary);
						//employees[i] = employee;
						util.addNewEmployee(employee);
						
						employeeList.add(employee);
						
					}
					//employeeList.add(employee);
					//util.addAllEmployees(employees);
					System.out.println("employeeList are added !!");
				} else
					System.out.println("No space available !!");
				break;
			case 3:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
					System.out.println("employee New Salary");
					salary = scanner.nextDouble();

					result = util.updateemployee(employeeId, salary);
					if (result)
						System.out.println("employee details are updated successfully !!");
					else
						System.out.println("Failed to update employee details");
				} else
					System.out.println("No employee Found !!");
				break;

			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					result=employeeList.remove(employee);
					//result = util.deleteemployee(employeeId);
					if (result)
						System.out.println("employee deleted successfully ");
					else
						System.out.println("Failed to delete employee");
				} else
					System.out.println("No employee Found !!");
				break;
			case 5:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				employeeList.remove(employee);
				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println("No employee Found !!");
				break;
			case 6:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue yes- no ??");
			continueChoice = scanner.next();
			
		} while (continueChoice.equals("yes"));
		System.out.println("Thank you");
	}
}
