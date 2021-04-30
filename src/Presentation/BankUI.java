package src.Presentation;

import java.util.Scanner;

import src.Business.Bank;
import src.Domain.Account;
import src.Domain.AccountWithLimit;
import src.Domain.SavingsAccount;

public class BankUI {
	private Bank _bank;
	
	public BankUI(Bank bank) {
		_bank = bank;
	}
	
	public void openAccount() {
		try {
			var input = new Scanner(System.in);
			
			System.out.println("Abrir conta");
			System.out.print("Informe o nome do titular: ");
			var holder = input.next();
			input.nextLine();

			System.out.println(
				"Informe o tipo de conta: \n" +
				"1. Conta corrente \n" +
				"2. Conta corrente com limite \n" +
				"3. Conta Poupança \n"
			);
			var accountType = input.nextInt();
			input.nextLine();

			Account account;

			switch(accountType){
				case 1: account = new Account(holder); break;
				case 2: account = new AccountWithLimit(holder); break;
				case 3: account = new SavingsAccount(holder); break;
				default: throw new IllegalArgumentException("Tipo de conta não existe!");
			}
		
			_bank.openAccount(account);
			
			System.out.println("Conta aberta com sucesso! \nSeu numero de conta eh: " + account.getNumber());
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return;
		} catch(Exception ex) {
			System.out.println("Valor informado não é válido");
			return;
		}
	}
	
	public void withdrawAccount() {
		try {
			var input = new Scanner(System.in);
			
			System.out.println("Deposita");
			System.out.print("Informar o número da conta: ");
			var number = input.nextInt();
			input.nextLine();

			System.out.println("Informar o valor do saque: ");
			var amount = input.nextDouble();
			input.nextLine();

			_bank.withdrawAccount(number, amount);
			
			System.out.println("Saque realizado com sucesso!");
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return;
		} catch(Exception ex) {
			System.out.println("Valor informado não é válido");
			return;
		}
	}
	
	public void depositAccount() {
		try {
			var input = new Scanner(System.in);
			
			System.out.println("Depósito");
			System.out.print("Informar o número da conta: ");
			var number = input.nextInt();
			input.nextLine();

			System.out.print("Informar o valor do deposito: ");
			var amount = input.nextDouble();
			input.nextLine();

			_bank.depositAccount(number, amount);
			
			System.out.println("Depósito realizado com sucesso!");
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return;
		} catch(Exception ex) {
			System.out.println("Valor informado não é válido");
			return;
		}
	}	
	
	public void extractAccount() {
		System.out.println("Extrato");
		System.out.print("Informar o número da conta: ");

		var input = new Scanner(System.in);

		try {
			var number = input.nextInt();
			input.nextLine();

			var extract = _bank.extractAccount(number);
			
			System.out.println(extract);
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return;
		} catch(Exception ex) {
			System.out.println("Valor informado não é valido");
			return;
		}
	}
	
	public void menu() {
		Scanner input = new Scanner(System.in);
		int option;
		
		do {
			System.out.println(
				"Bem vindo ao Banco \n" +
				"1. Abrir conta \n" +
				"2. Saque \n" +
				"3. Deposito \n" +
				"4. Extrato \n" +
				"0. Sair"
			);
			
			try {
				option = input.nextInt();
				input.nextLine();
			} catch(Exception ex) {
				System.out.println("Valor informado não é válido");
				
				break;
			}
			
			switch(option){
				case 1: openAccount(); break;
				case 2: withdrawAccount(); break;
				case 3: depositAccount(); break;
				case 4: extractAccount(); break;
				case 0: System.out.println("Ate mais!"); break;
				default: System.out.println("Opcao invalida"); break;
			}

		} while(option != 0);
	}	
	
	public static void main(String [] args) {
		BankUI bankUI = new BankUI(new Bank());
		bankUI.menu();
	}
}