package entities.typeAccounts;

import entities.Account;
import entities.Client;
import enums.AccountType;
import interfaces.IYield;

public class SavingsAccount extends Account implements IYield {

    public SavingsAccount(Client client) {
        super(client);
    }

    /**
     * Método que retorna o tipo da conta
     * 
     * @return - AccountType: Tipo da conta
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.SavingsAccount;
    }

    /**
     * Método que testa se o tipo da conta passado como parâmetro é igual ao tipo da
     * conta
     * 
     * @param account - Account: Conta a ser testada
     * @return - Boolean: True se o tipo da conta passada como parâmetro é igual ao
     *         tipo da conta
     */

    @Override
    public Boolean isAccountType(AccountType accountType) {
        return accountType == AccountType.SavingsAccount;
    }

    /**
     * Método que retorna o valor de rendimento a partir de uma quantidade de dias
     * 
     * @param days int - Dias
     * @return double - Valor de rendimento total
     */
    public double calculateYield(int days) {
        return (this.totalCash * (this.client.getClientCategory().getSavingBonus() + 0.09) / 100) * days;
    }
}
