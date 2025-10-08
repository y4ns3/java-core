package lessons.lesson03.BankSystem;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(String accountNumber, String fio, double balance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Счёт с таким номером уже существует!");
            return;
        }
        accounts.put(accountNumber, new BankAccount(accountNumber, fio, balance));
        System.out.println("Счёт успешно создан для: " + fio);
    }

    public void deleteAccount(String accountNumber) {
        if (accounts.remove(accountNumber) != null) {
            System.out.println("Счёт " + accountNumber + " удалён.");
        } else {
            System.out.println("Счёт не найден!");
        }
    }

    public void replenishAccount(String accountNumber, double amount) {
        BankAccount acc = accounts.get(accountNumber);
        if (acc == null) {
            System.out.println("Счёт не найден!");
            return;
        }
        if (amount <= 0) {
            System.out.println("Сумма пополнения должна быть больше нуля!");
            return;
        }
        acc.balance += amount;
        System.out.println("Счёт пополнен на " + amount + ". Новый баланс: " + acc.balance);
    }

    public void transferMoneyBetweenAccounts(String fromAccount, String toAccount, double amount) {
        BankAccount sender = accounts.get(fromAccount);
        BankAccount receiver = accounts.get(toAccount);

        if (sender == null || receiver == null) {
            System.out.println("Один из счетов не найден!");
            return;
        }
        if (sender.balance < amount) {
            System.out.println("Недостаточно средств на счёте " + fromAccount);
            return;
        }

        sender.balance -= amount;
        receiver.balance += amount;
        System.out.println("Переведено " + amount + " со счёта " + fromAccount + " на счёт " + toAccount);
    }

    public void getAccountInfo(String accountNumber) {
        BankAccount acc = accounts.get(accountNumber);
        if (acc != null) {
            System.out.println(acc.getInfo());
        } else {
            System.out.println("Счёт не найден!");
        }
    }
}