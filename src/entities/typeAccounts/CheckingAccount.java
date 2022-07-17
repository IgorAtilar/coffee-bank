package entities.typeAccounts;

import entities.Account;
import entities.Client;
import enums.AccountType;

public class CheckingAccount extends Account {

    public CheckingAccount(Client client) {
        super(client);
    }

    /**
     * Método que retorna o tipo da conta
     * 
     * @return - AccountType: Tipo da conta
     */

    @Override
    public AccountType getAccountType() {
        return AccountType.CheckingAccount;
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
        return this.getAccountType() == accountType;
    }

}
