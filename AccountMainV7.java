package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Savings;
import com.montran.pojo.Current;

public class AccountMainV7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int accountNumber;
		String name;
		double balance;
		int amount;
		int trainsactionChoice;
		String continueChoice;
		int accountChoice;
		boolean isSalary = false;
		boolean result;
		double overdraftBalance=0;
		double initialoverdraftBalance=0;
		
		System.out.println(" Hello Welcome to XYZ Bank !!");

		System.out.println("Account Choice Menu");
		System.out.println("1.. Savings");
		System.out.println("2.. Current");
		System.out.println("Enter your account choice");
		accountChoice = scanner.nextInt();

		switch (accountChoice) {
		case 1:
			System.out.println("Do you want to open salary account (true-false)");
			isSalary = scanner.nextBoolean();
			break;
		case 2:
			System.out.println("Enter overdraftbalance");
			//overdraftBalance = scanner.nextDouble();
			initialoverdraftBalance = scanner.nextDouble();
			overdraftBalance = initialoverdraftBalance;
			System.out.println("Your account is opened successfully!!");
			break;
		default:
			System.out.println("Invalid input !!");	
			break;
		}
		
		if(accountChoice==1 || accountChoice==2) {
		System.out.println("Enter account Number");
		accountNumber = scanner.nextInt();

		System.out.println("Enter Name");
		name = scanner.next();

		System.out.println("Enter Salary");
		balance = scanner.nextDouble();

		Savings savings = new Savings(accountNumber, name, balance, isSalary);
		Current current = new Current(accountNumber, name, balance, overdraftBalance,initialoverdraftBalance);
		
		
		
		do {
			System.out.println("Menu");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Balance");
			System.out.println("Enter your choice");
			trainsactionChoice = scanner.nextInt();

			switch (trainsactionChoice) {
			case 1:
				System.out.println("Enter amount to withdraw");
				amount = scanner.nextInt();
				if(accountChoice==1) {
				result = savings.withdraw(amount);
				if (result)
					System.out.println("Transaction Success !!");
				else
					System.out.println("Transaction Failed !!");}
				else if(accountChoice==2){
					result = current.withdraw(amount);
					if (result)
						System.out.println("Transaction Success !!");
					else
						System.out.println("Transaction Failed !!");	
				}
				else {System.out.println("Invalid input !!");	}
				break;
			case 2:
				System.out.println("Enter amount to deposit");
				amount = scanner.nextInt();
				if(accountChoice==1) {
				result = savings.deposit(amount);
				if (result)
					System.out.println("Transaction Success !!");
				else
					System.out.println("Transaction Failed !!");}
				else if(accountChoice==2) {
					result = current.deposit(amount);
					if (result)
						System.out.println("Transaction Success !!");
					else
						System.out.println("Transaction Failed !!");
				}
				else {System.out.println("Invalid input !!");	}
				break;
			case 3:
				if(accountChoice==1) {
				System.out.println("Account Balance :: " + savings.getBalance());}
				else if(accountChoice==2) {
				System.out.println("Account Balance :: " + current.getBalance());
				System.out.println("Overdraft Balance :: " + current.getOverdraftBalance());
				}
				else {System.out.println("Invalid input !!"); 	}
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
			if(continueChoice.equals("no"))
				System.out.println("Thank you for banking with us!!");
		} while (continueChoice.equals("yes"));
		scanner.close();

		}
		else {
			System.out.println("Enter correct account choice");
		}
		
	}

}
