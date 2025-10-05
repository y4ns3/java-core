package lessons.lesson03.bank;

public class BankAccount {
    private String fio;
    private String accountNumber;
    private double balance;

    public BankAccount(String fio, String accountNumber, double balance) {
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount){
        if (amount < 0){
            System.out.println("Amount can't be negative");
        }
        balance += amount;
    }
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }else{
            System.out.println("not enough balance");
        }
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
