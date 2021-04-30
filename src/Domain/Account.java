package src.Domain;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;

public class Account {
	protected static int _totalAccounts = 0;
	protected final int INITIAL_ACCOUNT_NUMBER = 1000;
	protected final int _number;
	protected String _holder;
	protected double _balance = 0;
	protected List<Transaction> _transactions = new ArrayList<Transaction>();

	public Account(String holder) {
		_number = INITIAL_ACCOUNT_NUMBER + _totalAccounts;
		_holder = holder;

		Account._totalAccounts++;
	}

	public int getNumber() {
		return _number;
	}

	public String getHolder() {
		return _holder;
	}

	public double getBalance() {
		return _balance;
	}

	public void deposit(Transaction transaction) throws IllegalArgumentException {
		if (transaction.getAmount() <= 0) {
			throw new IllegalArgumentException("Valor fornecido é inválido!");
		}

		_balance += transaction.getAmount();
		_transactions.add(transaction);
	}

	public void withdraw(Transaction transaction) throws IllegalArgumentException {
		if (transaction.getAmount() > _balance) {
			throw new IllegalArgumentException("Saldo insuficiente!");
		}

		_balance -= transaction.getAmount();
		_transactions.add(transaction);
	}

	public String extract() {
		var extract = toString() + "Transações realizadas: \n";

		for (var transaction : _transactions) {
			extract += transaction.toString();
		}

		return extract;
	}

	public String toString() {
		return "Numero: " + _number + "\nTitular: " + _holder + "\nSaldo: " + _balance + "\n";
	}
}
