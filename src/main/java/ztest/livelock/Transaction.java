package ztest.livelock;

/**
 * Author: Leon, created at: 05/12/2015, 9:55 PM.
 */

class Transaction implements Runnable {
  private BankAccount sourceAccount, destinationAccount;
  private double amount;

  Transaction(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
    this.sourceAccount = sourceAccount;
    this.destinationAccount = destinationAccount;
    this.amount = amount;
  }

  public void run() {
    while (!sourceAccount.tryTransfer(destinationAccount, amount)) {
    }
    System.out.printf("%s completed ", Thread.currentThread().getName());
  }

}