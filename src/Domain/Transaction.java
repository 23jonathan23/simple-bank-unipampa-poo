package src.Domain;

import java.time.LocalDate;

public class Transaction {
   private LocalDate _createdAt;
   private double _amount;
   private String _description;

   public Transaction(double amount, String description) {
       _createdAt = LocalDate.now();
       _amount = amount;
       _description = description;
   }

   public LocalDate getCreatedAt() {
       return _createdAt;
   }

   public double getAmount() {
       return _amount;
   }

   public String getDescription() {
       return _description;
   }

   @Override
   public String toString() {
       return "Data da transação: " + _createdAt.toString() + 
        " || Valor da transação: " + _amount + " || Descrição: " + _description + "\n";
   }
}
