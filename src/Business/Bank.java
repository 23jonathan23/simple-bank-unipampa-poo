package src.Business;

import java.util.ArrayList;
import java.util.List;

import src.Domain.Account;
import src.Domain.Transaction;

public class Bank {
	private final String DEFAULT_MESSAGE_ACCOUNT_NOT_FOUND = "Conta informada não existe!"; 
	private List<Account> _accounts = new ArrayList<Account>();
	
	public void openAccount(Account account) {
		_accounts.add(account);
	}
	
	public void withdrawAccount(int number, double amount) throws IllegalArgumentException {
		var account = getAccount(number);
		
		if(account != null) {
			var transaction = new Transaction(amount, "Saque da conta");
			try {
				account.withdraw(transaction);
				return;
			} catch (IllegalArgumentException ex) {
				throw ex;
			}
		}

		throw new IllegalArgumentException(DEFAULT_MESSAGE_ACCOUNT_NOT_FOUND);
	}

	public void depositAccount(int number, double amount) throws IllegalArgumentException {
		var account = getAccount(number);
		
		if(account != null) {
			var transaction = new Transaction(amount, "Depósito em conta");
			try {
				account.deposit(transaction);
				return;
			} catch (IllegalArgumentException ex) {
				throw ex;
			}
		}

		throw new IllegalArgumentException(DEFAULT_MESSAGE_ACCOUNT_NOT_FOUND);
	}

	public String extractAccount(int number) throws IllegalArgumentException {
		var account = getAccount(number);
		
		if(account != null) {
			return account.extract();
		}

		throw new IllegalArgumentException(DEFAULT_MESSAGE_ACCOUNT_NOT_FOUND);
	}

	private Account getAccount(int number) {
		for(var account : _accounts) {
			if(account.getNumber() == number)
				return account;
		}

		return null;
	}
}