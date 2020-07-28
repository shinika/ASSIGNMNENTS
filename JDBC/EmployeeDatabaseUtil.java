package com.montran.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeDatabaseUtil;

public class EmployeeMain {
	private static Employee employees[];

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "montran";
		String password = "montran";
		String sql = "";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		Scanner scanner = new Scanner(System.in);
		EmployeeDatabaseUtil util = new EmployeeDatabaseUtil(10);
	    List<Employee> employeeList ;
	    
		Employee employee;
		int employeeId;
		String name;
		double salary;
		int employeeChoice;
		boolean result;
		int numberOfemployeeList;
		String continueChoice;
		
		
		try {
			// 1. Load jdbc driver
			Class.forName(driver);
			System.out.println("Driver loaded successfully.");

			// 2. Connect to database
			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connection Success !! ");
				
//				
//
//				// 3. create query and pass it to preparedStatement
//				 deleted Successfully !!");

//				sql = "select * from employee_master order by employee_id";
//				preparedStatement = connection.prepareStatement(sql);
//
			//	resultSet = preparedStatement.executeQuery();
/*
				while (resultSet.next()) {
					System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
//					System.out.println("Name :: " + resultSet.getString("name"));
//					System.out.println("Salary :: " + resultSet.getDouble("salary"));
//					System.out.println("----------------------------------------");
				}*/

			

		do {
			
			
				
			employeeList = util.getAllemployees();
			for (Employee employeeTemp : employeeList) {
				if (employeeTemp != null) {
					System.out.println(employeeTemp.getEmployeeId() + "\t" + employeeTemp.getName() + "\t" + employeeTemp.getSalary());
				}
			}
			
			sql = "select * from employee_master order by employee_id";
			preparedStatement = connection.prepareStatement(sql);
//
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
				System.out.println("Name :: " + resultSet.getString("name"));
				System.out.println("Salary :: " + resultSet.getDouble("salary"));
				System.out.println("----------------------------------------");
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
				
				sql = "insert into employee_master values(?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, employee.getEmployeeId());
				preparedStatement.setString(2, employee.getName());
				preparedStatement.setDouble(3, employee.getSalary());

				// 4. execute query on database
				 preparedStatement.executeUpdate();
				
				 sql="";
				
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
						
						sql = "insert into employee_master values(?,?,?)";
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setInt(1, employee.getEmployeeId());
						preparedStatement.setString(2, employee.getName());
						preparedStatement.setDouble(3, employee.getSalary());
						
						preparedStatement.executeUpdate();
						sql="";
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
					
					sql = "update employee_master set name=? , salary=? where employee_id=?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, employee.getName());
					preparedStatement.setDouble(2, employee.getSalary());
					preparedStatement.setInt(3, employee.getEmployeeId());
					
					preparedStatement.executeUpdate();
					sql="";
					
					
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
					result= employeeList.remove(employee);
					//result = util.deleteemployee(employeeId);
					
					sql = "delete from employee_master where employee_id = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, employee.getEmployeeId());
	//
					preparedStatement.executeUpdate();
					sql="";
					
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
				
				sql = "select * from employee_master where employee_id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, employee.getEmployeeId());
				
				preparedStatement.executeQuery();
				sql="";
				connection.close();
				
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
		
		
			} else
				System.out.println("Connection failed !!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}