package src.Domain;

public class AccountWithLimit extends Account{
    private double _limit = 1000;
    
    public AccountWithLimit(String holder) {
        super(holder);
    }

    public double getLimit() {
        return _limit;
    }

    @Override
    public void withdraw(Transaction transaction) throws IllegalArgumentException {
		if(transaction.getAmount() > (_balance + _limit)) { 
            throw new IllegalArgumentException("Saldo insuficiente!");
        }

        _balance -= transaction.getAmount();
        _transactions.add(transaction);
	}

    @Override
    public String toString() {
		return super.toString() + "Limite: " + _limit + "\n";
	}
}
