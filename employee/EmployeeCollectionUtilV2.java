package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeCollectionUtilV2 {

	private List<Employee> employeeList = new ArrayList<Employee>();

	private int nextIndex = 0;
	private int maxIndex;

	public EmployeeCollectionUtilV2(int maxemployeeLenght) {
		employeeList = new ArrayList<Employee>(maxemployeeLenght);
		maxIndex = maxemployeeLenght;
	}

	public int getNextIndex() {
		return nextIndex;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public boolean addNewEmployee(Employee employee) {
		//if (nextIndex >= 0 && nextIndex < maxIndex) {
			//employeeList[nextIndex] = employee;
			employeeList.add(employee);
			//nextIndex++;
			return true;
		//}
		//return false;
	}

	public boolean addAllEmployees(Employee[] employee) {
		for (Employee emp : employee) {
			employeeList.add(emp);
			//addNewEmployee(emp);
		}
		return true;
	}

	public boolean updateemployee(int employeeId, double newSalary) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employee.setSalary(newSalary);
				return true;
			}
		}
		return false;
	}

	public boolean deleteemployee(int employeeId) {
		
				employeeList.remove(employeeId);
				return true;
		
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee != null) {
				if (employee.getEmployeeId() == employeeId)
					return employee;
			}

		}
		return null;

	}

	public List<Employee> getAllemployees() {
		return employeeList;
	}

}
