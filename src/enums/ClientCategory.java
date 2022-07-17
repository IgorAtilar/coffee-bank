package enums;

public enum ClientCategory {
    REGULAR("Cliente Regular", 0.0, 0.0, 5.5),
    VIP("Cliente VIP", 0.4, 0.12, 2.5),
    PREMIUM("Cliente Premium", 0.8, 0.24, 0.0);

    private String name;
    private Double investmentBonus;
    private Double savingBonus;
    private Double valuePerTransaction;

    /**
     * Construtor da classe ClientCategory
     * 
     * @param name                - String: Nome da categoria do cliente
     * @param investmentBonus     - Double: Bonus de investimento
     * @param savingBonus         - Double: Bonus de poupança
     * @param valuePerTransaction - Double: Valor da transação
     */
    private ClientCategory(String name, Double investmentBonus, Double savingBonus, Double valuePerTransaction) {
        this.name = name;
        this.investmentBonus = investmentBonus;
        this.savingBonus = savingBonus;
        this.valuePerTransaction = valuePerTransaction;
    }

    public String getName() {
        return name;
    }

    public Double getInvestmentBonus() {
        return this.investmentBonus;
    }

    public Double getSavingBonus() {
        return this.savingBonus;
    }

    public Double getValuePerTransaction() {
        return this.valuePerTransaction;
    }
}
