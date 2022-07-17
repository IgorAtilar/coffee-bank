package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Random;

import entities.Account;
import entities.Client;
import entities.typeAccounts.CheckingAccount;
import entities.typeAccounts.InvestmentAccount;
import entities.typeAccounts.SavingsAccount;
import enums.AccountType;
import enums.ClientCategory;

public class Main {

        static Random random = new Random();

        /**
         * Método que lê um arquivo de texto e retorna uma lista de clientes
         * 
         * @return Collection<Client> - lista de clientes
         */

        public static Collection<Client> loadClients() {
                Collection<Client> clientList = new ArrayList<>();

                File clients = new File("src/archives/clients.txt");
                boolean hasClients = clients.exists();

                if (hasClients) {

                        try (FileReader fr = new FileReader(clients)) {
                                BufferedReader br = new BufferedReader(fr);

                                while (br.ready()) {
                                        String line = br.readLine();
                                        String[] data = line.split(",");

                                        Client newClient = createClient(data[0], Integer.parseInt(data[1]),
                                                        data[2], data[3], data[4]);

                                        clientList.add(newClient);
                                }

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                createMockAccounts(clientList);
                return clientList;
        }

        /**
         * Método que cria um cliente a partir dos dados passados
         * 
         * @param name           String - nome do cliente
         * @param age            int - idade do cliente
         * @param cpf            String - cpf do cliente
         * @param password       String - senha do cliente
         * @param clientCategory String - categoria do cliente
         * @return
         */

        public static Client createClient(String name, Integer age, String cpf, String password,
                        String clientCategory) {

                Client client = null;

                switch (clientCategory) {
                        case "VIP":
                                client = new Client(name, age, cpf, password, ClientCategory.VIP);
                                break;

                        case "PREMIUM":
                                client = new Client(name, age, cpf, password, ClientCategory.PREMIUM);
                                break;
                        default:
                                client = new Client(name, age, cpf, password, ClientCategory.REGULAR);
                                break;
                }

                return client;
        }

        /**
         * Método que cria uma conta de teste para cada cliente
         * 
         * @param client Client - cliente que terá a conta criada
         * @return Account - conta criada
         */
        public static Account createMockAccount(Client client, int index) {
                Integer accountType = index;

                Account account = null;

                switch (accountType) {
                        case 0:
                                account = new CheckingAccount(client);
                                break;
                        case 1:
                                account = new InvestmentAccount(client);
                                break;
                        case 2:
                                account = new SavingsAccount(client);
                                break;
                        default:
                                account = new CheckingAccount(client);
                                break;
                }

                return account;

        }

        /**
         * Método que cria contas de teste para cada cliente
         * 
         * @param clientList Collection<Client> - lista de clientes
         */

        public static void createMockAccounts(Collection<Client> clients) {

                clients.stream().forEach(client -> {
                        for (int i = 0; i < 3; i++) {
                                Account account = createMockAccount(client, i);
                                client.addAccount(account);
                        }
                });

        }

        /**
         * Método de pausa do programa
         * 
         * @param keyboard BufferedReader - objeto para leitura de teclado
         * @throws IOException - exceção de entrada e saída
         */

        public static void pause(BufferedReader keyboard) throws IOException {
                System.out.println("================================================================================");
                System.out.println("||                       Pressione Enter para continuar                       ||");
                System.out.println("================================================================================");
                keyboard.readLine();
        }

        /**
         * Método que cria um loading de carregamento
         * 
         * @throws InterruptedException
         */

        public static void loading() throws InterruptedException {
                Thread.sleep(1000);
                cleanScreen();
                System.out.println("================================================================================");
                System.out.println("||                                (  )   (   )  )                             ||");
                System.out.println("||                                 ) (   )  (  (                              ||");
                System.out.println("||                                 ( )  (    ) )                              ||");
                System.out.println("||                                 _____________                              ||");
                System.out.println("||                                <_____________> ___                         ||");
                System.out.println("||                                |             |/ _ \\                        ||");
                System.out.println("||                                |    Coffee   | | | |                       ||");
                System.out.println("||                                |    Bank     | | | |                       ||");
                System.out.println("||                             ___|             |\\___/                        ||");
                System.out.println(
                                "||                            /    \\___________/    \\                         ||");
                System.out.println("||                            \\_____________________/                         ||");
                System.out.println("================================================================================");
                Thread.sleep(1000);
                cleanScreen();
                System.out.println("================================================================================");
                System.out.println("||                                 (  )   (   )  )                            ||");
                System.out.println("||                                ) (   )  (  (                               ||");
                System.out.println("||                                  ( )  (    ) )                             ||");
                System.out.println("||                                 _____________                              ||");
                System.out.println("||                                <_____________> ___                         ||");
                System.out.println("||                                |             |/ _ \\                        ||");
                System.out.println("||                                |    Coffee   | | | |                       ||");
                System.out.println("||                                |    Bank     | | | |                       ||");
                System.out.println("||                             ___|             |\\___/                        ||");
                System.out.println(
                                "||                            /    \\___________/    \\                         ||");
                System.out.println("||                            \\_____________________/                         ||");
                System.out.println("================================================================================");
                Thread.sleep(1000);
                cleanScreen();
                System.out.println("================================================================================");
                System.out.println("||                                (  )   (   )  )                             ||");
                System.out.println("||                                 ) (   )  (  (                              ||");
                System.out.println("||                                 ( )  (    ) )                              ||");
                System.out.println("||                                 _____________                              ||");
                System.out.println("||                                <_____________> ___                         ||");
                System.out.println("||                                |             |/ _ \\                        ||");
                System.out.println("||                                |    Coffee   | | | |                       ||");
                System.out.println("||                                |    Bank     | | | |                       ||");
                System.out.println("||                             ___|             |\\___/                        ||");
                System.out.println(
                                "||                            /    \\___________/    \\                         ||");
                System.out.println("||                            \\_____________________/                         ||");
                System.out.println("================================================================================");
                Thread.sleep(1000);
                cleanScreen();
                System.out.println("================================================================================");
                System.out.println("||                                 (  )   (   )  )                            ||");
                System.out.println("||                                ) (   )  (  (                               ||");
                System.out.println("||                                  ( )  (    ) )                             ||");
                System.out.println("||                                 _____________                              ||");
                System.out.println("||                                <_____________> ___                         ||");
                System.out.println("||                                |             |/ _ \\                        ||");
                System.out.println("||                                |    Coffee   | | | |                       ||");
                System.out.println("||                                |    Bank     | | | |                       ||");
                System.out.println("||                             ___|             |\\___/                        ||");
                System.out.println(
                                "||                            /    \\___________/    \\                         ||");
                System.out.println("||                            \\_____________________/                         ||");
                System.out.println("================================================================================");
                Thread.sleep(1000);
                cleanScreen();

        }

        /**
         * Método de login do sistema
         * 
         * @param keyboard   BufferedReader - objeto para leitura de teclado
         * @param clientList Collection<Client> - lista de clientes
         * @return Client - cliente logado
         * @throws IllegalStateException - exceção de estado ilegal
         * @throws IOException           - exceção de entrada e saída
         */

        public static Client login(BufferedReader keyboard, Collection<Client> clientList)
                        throws IllegalStateException, IOException {
                Client currentClient = null;
                Integer option = -1;

                do {
                        cleanScreen();
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                          Bem-vindo ao CoffeeBank!                          ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                             1 - Realizar login                             ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                                  0 - Sair                                  ||");
                        System.out.println(
                                        "================================================================================");
                        try {
                                option = Integer.parseInt(keyboard.readLine());
                                Integer loginOption = -1;

                                switch (option) {
                                        case 1:

                                                do {

                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                               Digite seu CPF:                              ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        String cpf = keyboard.readLine();

                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                              Digite sua senha:                             ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        String password = keyboard.readLine();

                                                        boolean isCpfInvalid = clientList.stream()
                                                                        .noneMatch(client -> client.isClientCpf(cpf));

                                                        boolean isPasswordInvalid = clientList.stream()
                                                                        .noneMatch(client -> client
                                                                                        .isClientPassword(password));

                                                        if (isCpfInvalid || isPasswordInvalid) {
                                                                cleanScreen();
                                                                System.out.println(
                                                                                "================================================================================");
                                                                System.out.println(
                                                                                "||                           CPF ou senha inválidos!                          ||");
                                                                System.out.println(
                                                                                "================================================================================");
                                                                pause(keyboard);
                                                                break;
                                                        } else {
                                                                return currentClient = clientList.stream()
                                                                                .filter(client -> client
                                                                                                .isClientCpf(cpf))
                                                                                .filter(client -> client
                                                                                                .isClientPassword(
                                                                                                                password))
                                                                                .findFirst().get();
                                                        }

                                                } while (loginOption == -1);

                                                break;
                                        case 0:
                                                System.exit(0);
                                                break;
                                        default:
                                                option = -1;
                                                throw new IllegalStateException("Opção inválida.");
                                }

                        } catch (InputMismatchException | NumberFormatException | IllegalStateException e) {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Opção inválida!                              ||");
                                System.out.println(
                                                "================================================================================");
                                pause(keyboard);

                        }

                } while (option != 0 || option != 1 && currentClient == null);

                return currentClient;

        }

        /**
         * Método que retorna uma string com uma saudação para o cliente logado conforme
         * a categoria do mesmo
         * 
         * @param client Client - cliente logado
         * @return String - saudação do cliente
         */

        public static String getCilentGreetings(Client client) {
                if (client.getClientCategory().equals(ClientCategory.PREMIUM)) {
                        return "*** Bem-vindo, " + client.getName() + "! ***";
                } else if (client.getClientCategory().equals(ClientCategory.VIP)) {
                        return "** Bem-vindo, " + client.getName() + "! **";
                } else {
                        return "* Bem-vindo, " + client.getName() + "! *";
                }
        }

        /**
         * Método do menu para o cliente logado no sistema
         * 
         * @param client   Client - cliente logado
         * @param keyboard BufferedReader - objeto para leitura de teclado
         * @return Integer - opção escolhida pelo cliente
         * @throws IllegalStateException - exceção de estado ilegal
         * @throws IOException           - exceção de entrada e saída
         */

        public static int loggedMenu(Client client, BufferedReader keyboard) throws IllegalStateException, IOException {
                Integer option = -1;
                do {
                        cleanScreen();
                        System.out.println(
                                        "================================================================================");
                        System.out.println(getCilentGreetings(client));
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                            1 - Selecionar conta                            ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                    2 - Visualizar bônus de investimento                    ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                      3 - Visualizar bônus de poupança                      ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                        4 - Visualizar taxa de saque                        ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                                  0 - Sair                                  ||");
                        System.out.println(
                                        "================================================================================");

                        try {
                                option = Integer.parseInt(keyboard.readLine());

                                switch (option) {
                                        case 1:
                                                return 1;
                                        case 2:
                                                return 2;
                                        case 3:
                                                return 3;
                                        case 4:
                                                return 4;
                                        case 0:
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                   Obrigado por ser cliente CoffeeBank :D                   ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.exit(0);
                                                break;
                                        default:
                                                option = -1;
                                                throw new IllegalStateException("Opção inválida.");
                                }

                        } catch (InputMismatchException | NumberFormatException | IllegalStateException e) {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Opção inválida!                              ||");
                                System.out.println(
                                                "================================================================================");
                                pause(keyboard);
                        }

                } while (option == -1);

                return option;
        }

        /**
         * Método de menu para as contas do cliente logado
         * 
         * @param client   Client - cliente logado
         * @param keyboard BufferedReader - objeto para leitura de teclado
         * @return Integer - opção escolhida pelo cliente
         * @throws IllegalStateException - exceção de estado ilegal
         * @throws IOException           - exceção de entrada e saída
         */

        public static Integer accountMenu(Client client, BufferedReader keyboard)
                        throws IllegalStateException, IOException {
                Integer option = -1;

                do {
                        cleanScreen();
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                            Selecione uma conta:                            ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                             1 - Conta corrente                             ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                             2 - Conta poupança                             ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                           3 - Conta Investimento                           ||");
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                                 0 - Voltar                                 ||");
                        System.out.println(
                                        "================================================================================");

                        try {
                                option = Integer.parseInt(keyboard.readLine());

                                switch (option) {
                                        case 0:
                                                return 0;

                                        case 1:
                                                Boolean isCheckingAccountInvalid = client.getAccountList().stream()
                                                                .noneMatch(account -> account.isAccountType(
                                                                                AccountType.CheckingAccount));

                                                if (isCheckingAccountInvalid) {
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                    Você não possui uma conta corrente :(                   ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        pause(keyboard);
                                                        break;
                                                } else {
                                                        return 1;
                                                }

                                        case 2:
                                                Boolean isSavingsAccountInvalid = client.getAccountList().stream()
                                                                .noneMatch(account -> account.isAccountType(
                                                                                AccountType.SavingsAccount));

                                                if (isSavingsAccountInvalid) {
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                    Você não possui uma conta poupança D:                   ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        pause(keyboard);
                                                        break;
                                                } else {
                                                        return 2;
                                                }
                                        case 3:
                                                Boolean isInvestmentAccountInvalid = client.getAccountList().stream()
                                                                .noneMatch(account -> account.isAccountType(
                                                                                AccountType.InvestmentAccount));

                                                if (isInvestmentAccountInvalid) {
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                Você não possui uma conta de investimento :c                ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        pause(keyboard);
                                                        break;
                                                } else {
                                                        return 3;
                                                }

                                        default:
                                                option = -1;
                                                throw new IllegalStateException("Opção inválida.");
                                }

                        } catch (InputMismatchException | NumberFormatException | IllegalStateException e) {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Opção inválida!                              ||");
                                System.out.println(
                                                "================================================================================");
                                pause(keyboard);

                        }

                } while (option == -1);
                return option;

        }

        /**
         * Método de menu para as operações de conta corrente
         * 
         * @param client   Client - cliente logado
         * @param keyboard BufferedReader - objeto para leitura de teclado
         * @return Integer - opção escolhida pelo cliente
         * @throws IOException - exceção de entrada e saída
         */

        public static Integer checkingAccountMenu(Client client, BufferedReader keyboard) throws IOException {

                CheckingAccount accountSelected = client.getCheckingAccount();

                Integer option = -1;

                do {

                        try {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Conta Corrente                               ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                           Seleciona uma operação:                          ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                           1 - Depositar dinheiro                           ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                            2 - Retirar dinheiro                            ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               3 - Ver extrato                              ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                                 0 - Voltar                                 ||");
                                System.out.println(
                                                "================================================================================");
                                option = Integer.parseInt(keyboard.readLine());

                                switch (option) {
                                        case 0:

                                                return 0;

                                        case 1:
                                                option = -1;
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                         Digite o valor a depositar:                        ||");
                                                System.out.println(
                                                                "================================================================================");
                                                Double depositValue = Double.parseDouble(keyboard.readLine());
                                                accountSelected.depositMoney(depositValue);
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                        Valor depositado com sucesso!                       ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println("Valor depositado: R$ " + depositValue);
                                                System.out.println("Saldo atual: R$ " + accountSelected.getTotalCash());
                                                pause(keyboard);
                                                break;

                                        case 2:
                                                option = -1;
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                          Digite o valor a retirar:                         ||");
                                                System.out.println(
                                                                "================================================================================");
                                                Double withdrawValue = Double.parseDouble(keyboard.readLine());

                                                if (accountSelected.withdrawMoney(withdrawValue)) {
                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                         Valor retirado com sucesso!                        ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "Valor retirado: R$ " + withdrawValue + "\n");
                                                        System.out.println("Saldo atual: R$ "
                                                                        + accountSelected.getTotalCash());
                                                        System.out.println(
                                                                        "Taxa por saque: R$ " + client
                                                                                        .getClientCategory()
                                                                                        .getValuePerTransaction());
                                                        pause(keyboard);
                                                } else {
                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                      Não é possível sacar esse valor!                      ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println("Saldo atual: R$ "
                                                                        + accountSelected.getTotalCash());
                                                        System.out.println(
                                                                        "Taxa de saque: R$ " + client
                                                                                        .getClientCategory()
                                                                                        .getValuePerTransaction());
                                                        pause(keyboard);
                                                }

                                                break;

                                        case 3:
                                                option = -1;

                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                              Extrato da conta:                             ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(accountSelected.printStatement());
                                                pause(keyboard);
                                                break;

                                        default:
                                                option = -1;
                                                throw new IllegalStateException("Opção inválida.");
                                }

                        } catch (InputMismatchException | NumberFormatException | IllegalStateException e) {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Opção inválida!                              ||");
                                System.out.println(
                                                "================================================================================");
                                pause(keyboard);

                        }

                } while (option == -1);

                return option;
        }

        /**
         * Método de menu para as operações de conta poupança
         * 
         * @param client   Client - cliente logado
         * @param keyboard BufferedReader - objeto para leitura de teclado
         * @return Integer - opção escolhida pelo cliente
         * @throws IOException - exceção de entrada e saída
         */

        public static Integer savingsAccountMenu(Client client, BufferedReader keyboard) throws IOException {

                SavingsAccount accountSelected = client.getSavingsAccount();

                Integer option = -1;

                do {

                        try {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Conta Poupança                               ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                           Seleciona uma operação:                          ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                           1 - Depositar dinheiro                           ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                            2 - Retirar dinheiro                            ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               3 - Ver extrato                              ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                             4 - Ver rendimento                             ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                                 0 - Voltar                                 ||");
                                System.out.println(
                                                "================================================================================");
                                option = Integer.parseInt(keyboard.readLine());

                                switch (option) {
                                        case 0:

                                                return 0;

                                        case 1:
                                                option = -1;
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                         Digite o valor a depositar:                        ||");
                                                System.out.println(
                                                                "================================================================================");
                                                Double depositValue = Double.parseDouble(keyboard.readLine());
                                                accountSelected.depositMoney(depositValue);
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                        Valor depositado com sucesso!                       ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println("Valor depositado: R$ " + depositValue);
                                                System.out.println("Saldo atual: R$ " + accountSelected.getTotalCash());
                                                pause(keyboard);
                                                break;

                                        case 2:
                                                option = -1;
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                          Digite o valor a retirar:                         ||");
                                                System.out.println(
                                                                "================================================================================");
                                                Double withdrawValue = Double.parseDouble(keyboard.readLine());
                                                if (accountSelected.withdrawMoney(withdrawValue)) {
                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                         Valor retirado com sucesso!                        ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "Valor retirado: R$ " + withdrawValue + "\n");
                                                        System.out.println("Saldo atual: R$ "
                                                                        + accountSelected.getTotalCash());
                                                        System.out.println(
                                                                        "Taxa por saque: R$ " + client
                                                                                        .getClientCategory()
                                                                                        .getValuePerTransaction());

                                                        pause(keyboard);
                                                } else {
                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                      Não é possível sacar esse valor!                      ||");

                                                        System.out.println("Saldo atual: R$ "
                                                                        + accountSelected.getTotalCash());
                                                        System.out.println(
                                                                        "Taxa de saque: R$ " + client
                                                                                        .getClientCategory()
                                                                                        .getValuePerTransaction());

                                                        pause(keyboard);
                                                }
                                                break;

                                        case 3:
                                                option = -1;

                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                              Extrato da conta:                             ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(accountSelected.printStatement());
                                                pause(keyboard);
                                                break;

                                        case 4:
                                                option = -1;

                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                        Informe a quantidade de dias:                       ||");
                                                System.out.println(
                                                                "================================================================================");
                                                int days = Integer.parseInt(keyboard.readLine());
                                                Double yieldValue = accountSelected.calculateYield(days);
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println("Em " + days + " dias, sua poupança vai render: R$ "
                                                                + yieldValue);
                                                double totalValue = accountSelected.getTotalCash()
                                                                + yieldValue;
                                                System.out.println("Seu saldo após " + days + " dias : R$ "
                                                                + String.format(String.format("%.2f", totalValue)));

                                                pause(keyboard);
                                                break;

                                        default:
                                                option = -1;
                                                throw new IllegalStateException("Opção inválida.");
                                }

                        } catch (InputMismatchException | NumberFormatException | IllegalStateException e) {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Opção inválida!                              ||");
                                System.out.println(
                                                "================================================================================");
                                pause(keyboard);

                        }

                } while (option == -1);

                return option;
        }

        /**
         * Método de menu para as operações de conta de investimento
         * 
         * @param client   Client - cliente logado
         * @param keyboard BufferedReader - leitor de teclado
         * @return int - opção escolhida pelo usuário
         * @throws IOException - exceção de entrada e saída
         */

        public static Integer investmentAccountMenu(Client client, BufferedReader keyboard) throws IOException {

                InvestmentAccount accountSelected = client.getInvestmentAccount();

                Integer option = -1;

                do {

                        try {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                             Conta Investimento                             ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                           Seleciona uma operação:                          ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                           1 - Depositar dinheiro                           ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                            2 - Retirar dinheiro                            ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               3 - Ver extrato                              ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                             4 - Ver rendimento                             ||");
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                                 0 - Voltar                                 ||");
                                System.out.println(
                                                "================================================================================");
                                option = Integer.parseInt(keyboard.readLine());

                                switch (option) {
                                        case 0:

                                                return 0;

                                        case 1:
                                                option = -1;
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                         Digite o valor a depositar:                        ||");
                                                System.out.println(
                                                                "================================================================================");
                                                Double depositValue = Double.parseDouble(keyboard.readLine());
                                                accountSelected.depositMoney(depositValue);
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                        Valor depositado com sucesso!                       ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println("Valor depositado: R$ " + depositValue);
                                                System.out.println("Saldo atual: R$ " + accountSelected.getTotalCash());
                                                pause(keyboard);
                                                break;

                                        case 2:
                                                option = -1;
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                          Digite o valor a retirar:                         ||");
                                                System.out.println(
                                                                "================================================================================");
                                                Double withdrawValue = Double.parseDouble(keyboard.readLine());
                                                if (accountSelected.withdrawMoney(withdrawValue)) {
                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                         Valor retirado com sucesso!                        ||");
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "Valor retirado: R$ " + withdrawValue + "\n");
                                                        System.out.println("Saldo atual: R$ "
                                                                        + accountSelected.getTotalCash());
                                                        System.out.println(
                                                                        "Taxa por saque: R$ " + client
                                                                                        .getClientCategory()
                                                                                        .getValuePerTransaction());

                                                        pause(keyboard);
                                                } else {
                                                        cleanScreen();
                                                        System.out.println(
                                                                        "================================================================================");
                                                        System.out.println(
                                                                        "||                      Não é possível sacar esse valor!                      ||");

                                                        System.out.println("Saldo atual: R$ "
                                                                        + accountSelected.getTotalCash());
                                                        System.out.println(
                                                                        "Taxa de saque: R$ " + client
                                                                                        .getClientCategory()
                                                                                        .getValuePerTransaction());

                                                        pause(keyboard);
                                                }
                                                break;

                                        case 3:
                                                option = -1;

                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                              Extrato da conta:                             ||");
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(accountSelected.printStatement());
                                                pause(keyboard);
                                                break;

                                        case 4:
                                                option = -1;

                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                        Informe a quantidade de dias:                       ||");
                                                System.out.println(
                                                                "================================================================================");
                                                int days = Integer.parseInt(keyboard.readLine());
                                                Double yieldValue = accountSelected.calculateYield(days);
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println("Em " + days
                                                                + " dias, sua conta investimento vai render "
                                                                + yieldValue);
                                                double totalValue = accountSelected.getTotalCash()
                                                                + yieldValue;
                                                System.out.println("Seu saldo após " + days + " dias : R$ "
                                                                + String.format(String.format("%.2f", totalValue)));

                                                pause(keyboard);
                                                break;

                                        default:
                                                option = -1;
                                                throw new IllegalStateException("Opção inválida.");
                                }

                        } catch (InputMismatchException | NumberFormatException | IllegalStateException e) {
                                cleanScreen();
                                System.out.println(
                                                "================================================================================");
                                System.out.println(
                                                "||                               Opção inválida!                              ||");
                                System.out.println(
                                                "================================================================================");
                                pause(keyboard);

                        }

                } while (option == -1);

                return option;
        }

        /**
         * Método que limpa a tela
         * 
         */
        public static void cleanScreen() {
                System.out.print("\033[H\033[2J");
                System.out.flush();
        }

        public static void main(String[] args) throws Exception {
                loading();
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                Collection<Client> clientList = loadClients();

                Client client = login(keyboard, clientList);

                if (client == null) {
                        cleanScreen();
                        System.out.println(
                                        "================================================================================");
                        System.out.println(
                                        "||                   Obrigado por ser cliente CoffeeBank :D                   ||");
                        System.out.println(
                                        "================================================================================");
                        System.exit(0);
                }

                int option = -1;
                int optionAccount = -1;

                do {

                        option = loggedMenu(client, keyboard);

                        switch (option) {
                                case 0:
                                        cleanScreen();
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(
                                                        "||                   Obrigado por ser cliente CoffeeBank :D                   ||");
                                        System.out.println(
                                                        "================================================================================");
                                        System.exit(0);
                                        break;

                                case 1:
                                        cleanScreen();
                                        optionAccount = accountMenu(client, keyboard);

                                        try {

                                                switch (optionAccount) {
                                                        case 0:
                                                                option = -1;
                                                                break;
                                                        case 1:
                                                                option = -1;
                                                                optionAccount = checkingAccountMenu(client, keyboard);

                                                                break;
                                                        case 2:
                                                                option = -1;
                                                                optionAccount = savingsAccountMenu(client, keyboard);

                                                                break;
                                                        case 3:
                                                                option = -1;
                                                                optionAccount = investmentAccountMenu(client, keyboard);

                                                                break;
                                                        default:
                                                                option = -1;
                                                                throw new IllegalStateException("Opção inválida.");
                                                }
                                        } catch (IllegalStateException e) {
                                                cleanScreen();
                                                System.out.println(
                                                                "================================================================================");
                                                System.out.println(
                                                                "||                               Opção inválida!                              ||");
                                                System.out.println(
                                                                "================================================================================");
                                                pause(keyboard);
                                        }
                                        break;

                                case 2:
                                        option = -1;
                                        cleanScreen();
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(
                                                        "||                           Bônus de investimento:                           ||");
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(client.getClientCategory().getInvestmentBonus() + "%");
                                        System.out.println(
                                                        "================================================================================");
                                        pause(keyboard);
                                        break;

                                case 3:
                                        option = -1;
                                        cleanScreen();
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(
                                                        "||                           Bônus de poupança:                             ||");
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(client.getClientCategory().getSavingBonus() + "%");
                                        System.out.println(
                                                        "================================================================================");
                                        pause(keyboard);
                                        break;
                                case 4:
                                        option = -1;
                                        cleanScreen();
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(
                                                        "||                           Taxa de saque:                                 ||");
                                        System.out.println(
                                                        "================================================================================");
                                        System.out.println(client.getClientCategory().getValuePerTransaction());
                                        System.out.println(
                                                        "================================================================================");
                                        pause(keyboard);
                                        break;

                        }

                } while (option == -1);
        }
}
