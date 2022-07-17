package entities;

import java.util.ArrayList;
import java.util.Collection;

import entities.typeAccounts.CheckingAccount;
import entities.typeAccounts.InvestmentAccount;
import entities.typeAccounts.SavingsAccount;
import enums.AccountType;
import enums.ClientCategory;

public class Client {
    private String name;
    private ClientCategory clientCategory;
    private Integer age;
    private String cpf;
    private String password;

    private Collection<Account> accountList;

    /**
     * Método construtor da classe Client
     * 
     * @param name       - String: Nome do cliente
     * @param age        - Integer: Idade do cliente
     * @param cpf        - String: CPF do cliente
     * @param password   - String: Senha do cliente
     * @param clientType - ClientType: Categoria do cliente. Ex: REGULAR | VIP |
     *                   PREMIUM
     */
    public Client(String name, Integer age, String cpf, String password, ClientCategory clientCategory) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.password = password;
        this.clientCategory = clientCategory;
        this.accountList = new ArrayList<>();
    }

    /**
     * Método que retorna o nome do cliente
     * 
     * @return - String: Nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna a categoria/tipo do cliente
     * 
     * @return - ClientType: Categoria do cliente. Ex: REGULAR | VIP | PREMIUM
     */
    public ClientCategory getClientCategory() {
        return this.clientCategory;
    }

    /**
     * Método que define a categoria/tipo do cliente
     * 
     * @param clientCategory - ClientCategory: Categoria do cliente. Ex: REGULAR |
     *                       VIP |
     *                       PREMIUM
     */
    public void setClientCategory(ClientCategory clientCategory) {
        this.clientCategory = clientCategory;
    }

    /**
     * Método que retorna a idade do cliente
     * 
     * @return - Integer: Idade do cliente
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Método que retorna o CPF do cliente
     * 
     * @return - String: CPF do cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Método que retorna se a senha informada é igual a senha do cliente
     * 
     * @param - String: Senha a ser comparada
     * @return - Boolean: True se a senha informada é igual a senha do cliente
     */
    public Boolean isClientPassword(String attemptPassword) {
        return this.password.equals(attemptPassword);
    }

    /**
     * Método que retorna se o cpf informado é igual ao cpf do cliente
     * 
     * @param attemptCpf - String: CPF a ser comparado
     * @return - Boolean: True se o CPF informado é igual ao CPF do cliente
     */

    public Boolean isClientCpf(String attemptCpf) {
        return this.cpf.equals(attemptCpf);

    }

    /**
     * Método que adiciona uma nova conta na lista de contas do cliente
     * 
     * @return - Boolean: True se a conta foi adicionada com sucesso
     */

    public boolean addAccount(Account account) {
        boolean status = false;

        this.accountList.add(account);
        status = true;

        return status;
    }

    /**
     * Método que retorna a lista de contas do cliente
     * 
     * @return - Collection<Account>: Lista de contas do cliente
     */

    public Collection<Account> getAccountList() {
        return accountList;
    }

    /**
     * Método que retorna a conta corrente do cliente
     * 
     * @return - CheckingAccount: Conta corrente do cliente
     */

    public CheckingAccount getCheckingAccount() {
        return (CheckingAccount) this.accountList.stream()
                .filter(account -> account.isAccountType(AccountType.CheckingAccount))
                .findFirst().get();
    }

    /**
     * Método que retorna a conta poupança do cliente
     * 
     * @return - SavingsAccount: Conta poupança do cliente
     */

    public SavingsAccount getSavingsAccount() {
        return (SavingsAccount) this.accountList.stream()
                .filter(account -> account.isAccountType(AccountType.SavingsAccount))
                .findFirst().get();
    }

    /**
     * Método que retorna a conta de investimento do cliente
     * 
     * @return - InvestmentAccount: Conta de investimento do cliente
     */

    public InvestmentAccount getInvestmentAccount() {
        return (InvestmentAccount) this.accountList.stream()
                .filter(account -> account.isAccountType(AccountType.InvestmentAccount))
                .findFirst().get();
    }

}
