package enums;

public enum AccountType {
  CheckingAccount("Conta corrente"), // Conta corrente
  SavingsAccount("Conta poupança"), // Conta Poupanca
  InvestmentAccount("Conta investimento"); // Conta de investimento

  private String name;

  /**
   * Construtor da classe AccountType
   * 
   * @param name - String: Nome do tipo da conta
   */
  private AccountType(String name) {
    this.name = name;
  }

  public String getType() {
    return this.name;
  }
}
