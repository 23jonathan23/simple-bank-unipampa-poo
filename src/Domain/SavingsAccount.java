package src.Domain;

import java.time.LocalDate;

public class SavingsAccount extends Account {
    private LocalDate _birthday;

    public SavingsAccount(String holder) {
        super(holder);

        _birthday = LocalDate.now();
    }

    public int getBirthday() {
        return _birthday.getDayOfMonth();
    }

    @Override
    public String toString() {
		return super.toString() + "Aniversário da conta é no dia: " + getBirthday() + "\n";
	}
}
