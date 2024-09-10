package com.example.bank;

import java.util.Scanner;

public class BankAccount {
    private final int accountNumber;
    private final String agencyID;
    private final String name;
    private double value;

    public BankAccount(
        int accountNumber,
        String agencyID,
        String name,
        double value
    ) {
        this.accountNumber = accountNumber;
        this.agencyID = agencyID;
        this.name = name;
        this.value = value;
    }

    public static BankAccount accountCreateFromTerminal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the account number: ");
        int accountNumber = scanner.nextInt();

        System.out.println("Enter the agency ID: ");
        String agencyID = scanner.next();

        System.out.println("Enter the name: ");
        String name = scanner.next();

        System.out.println("Enter the value: ");
        double value = scanner.nextDouble();

        BankAccount account = new BankAccount(accountNumber, agencyID, name, value);
        printBankAccountInit(account);
        return account;
    }

    public static void printBankAccountInit(BankAccount account) {
        String accountPresentation = "Olá " + account.name + ",";
        accountPresentation += ", obrigado por criar uma conta em nosso banco, sua agência é " + account.agencyID;
        accountPresentation += " e o número da sua conta é " + account.accountNumber;
        accountPresentation += " com o valor de R$" + account.value + " disponível pra saque.";
        System.out.println(accountPresentation);
        System.out.println("--------------------");
    }

    private void transaction(double value) {
        transaction(value, false);
    }

    private void transaction(double value, Boolean isPercent) {
        double oldValue = this.value;
        if (isPercent) {
            value = (value * this.value) / 100;
        }
        String movement = value < 0 ? "Withdrew" : "Deposit";

        if (this.value + value >= 0) {
            this.value += value;
            System.out.println("Old value:\t$ " + oldValue
                + "\n" + movement + ":\t$ " + value
                + "\nNew value:\t$ " + this.value);
            System.out.println("--------------------");
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void deposit(double value) {
        transaction(value);
    }

    public void deposit(double value, Boolean percent) {
        transaction(value, percent);
    }

    public void withdraw(double value) {
        transaction(-value);
    }

    public void withdraw(double value, Boolean percent) {
        transaction(-value, percent);
    }
}
