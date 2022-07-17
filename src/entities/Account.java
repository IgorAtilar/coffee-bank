package entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import enums.AccountType;
import enums.ClientCategory;

public abstract class Account {
    protected Client client;
    private int id;
    protected double totalCash;
    protected Collection<String> transactionList;

    /**
     * Método construtor da classe Account
     * 
     * @param client
     */
    public Account(Client client) {
        this.id = hashCode();
        this.client = client;
        this.totalCash = 0.0;
        this.transactionList = new ArrayList<String>();
    }

    /**
     * Método que retorna o identificador da conta
     * 
     * @return - Int: Identificador da conta
     */
    public int getId() {
        return this.id;
    }

    /**
     * Método que retorna o cliente dono da conta
     * 
     * @return Client: Cliente dono da conta
     */

    public Client getClient() {
        return this.client;
    }

    /**
     * Método que retorna o tipo da conta
     * 
     * @return - AccountType: Tipo da conta
     */
    public abstract AccountType getAccountType();

    /**
     * Método que retorna o saldo da conta
     * 
     * @return - Double: Saldo da conta
     */

    public double getTotalCash() {
        return this.totalCash;
    }

    /***
     * Método que verifica se o tipo de conta informado é o tipo da conta
     * 
     * @param accountType - AccountType: Tipo da conta
     * @return Boolean - True se o tipo da conta for igual ao tipo informado
     */

    public abstract Boolean isAccountType(AccountType accountType);

    /**
     * Método para depositar um valor na conta
     * 
     * @param value - Double: Valor a ser depositado na conta
     * @return Boolean - True se o valor for depositado com sucesso
     */
    public boolean depositMoney(Double amount) {
        Boolean result = false;
        Date date = new Date();

        this.totalCash += amount;
        addTransactionsHistory(amount, date, "depositMoney");
        result = true;

        return result;
    }

    /**
     * Método para sacar um valor da conta
     * 
     * @param value - Double: Valor a ser sacado da conta
     * @return Boolean - True se o valor for sacado com sucesso
     */
    public boolean withdrawMoney(Double value) {
        Boolean result = false;
        Date date = new Date();
        ClientCategory clientCategory = this.client.getClientCategory();
        Double valuePerTransaction = clientCategory.getValuePerTransaction();

        if (value <= (this.totalCash - valuePerTransaction)) {
            this.totalCash -= valuePerTransaction + value;
            addTransactionsHistory(value, date, "withdrawMoney");
            result = true;
        }

        return result;
    }

    /**
     * Esse metodo serve para gerar pegar o extrato das transacoes.
     * 
     * @param value                - valor que vai aparecer no extrato
     * @param date                 - Passar uma data no formato Date.
     * @param typeTransictionStrin - tipo de transacao, sendo ela "withdrawMoney" ou
     *                             "depositMoney"
     */

    private void addTransactionsHistory(Double value, Date date, String typeTransictionString) {
        SimpleDateFormat format = new SimpleDateFormat();
        StringBuilder transictionBuilder = new StringBuilder();

        transictionBuilder.append("================================================================================\n");
        transictionBuilder.append("Data: " + format.format(date) + "\n");
        if (typeTransictionString == "withdrawMoney") {
            transictionBuilder.append("Valor retirado: R$" + Double.toString(value) + "\n");
        } else {
            transictionBuilder.append("Adicionado o valor de: R$" + Double.toString(value) + "\n");
        }
        transictionBuilder.append("================================================================================\n");
        this.transactionList.add(transictionBuilder.toString());
    }

    /**
     * Método que retorna o extrato da conta
     * 
     * @return - String: Extrato da conta
     */

    public String printStatement() {
        StringBuilder statementBuilder = new StringBuilder();
        statementBuilder.append("Saldo: R$" + this.getTotalCash() + "\n");
        if (this.transactionList.size() > 0) {
            for (String transaction : this.transactionList) {
                statementBuilder.append(transaction);
            }
        }
        return statementBuilder.toString();
    };

}
