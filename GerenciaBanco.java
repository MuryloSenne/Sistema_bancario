import javax.swing.JOptionPane;

public class GerenciaBanco {

    public static void main(String[] args) {
        // Introdução e obtenção de informações do usuário
        String nome = JOptionPane.showInputDialog("Bem-vindo ao sistema de gerenciamento bancário!\nDigite seu nome:");
        String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome:");
        String cpf = JOptionPane.showInputDialog("Digite seu CPF:");

        // Criação da conta bancária associada ao usuário
        BankAccount bankAccount = new BankAccount(nome, sobrenome, cpf);

        while (true) {
            String[] options = { "Consultar saldo", "Realizar depósito", "Realizar retirada", "Sair" };
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    bankAccount.displayBalance();
                    break;
                case 1:
                    String depositInput = JOptionPane.showInputDialog("Digite o valor para depósito:");
                    if (depositInput != null) {
                        double depositAmount = Double.parseDouble(depositInput);
                        bankAccount.deposit(depositAmount);
                    }
                    break;
                case 2:
                    String withdrawalInput = JOptionPane.showInputDialog("Digite o valor para retirada:");
                    if (withdrawalInput != null) {
                        double withdrawalAmount = Double.parseDouble(withdrawalInput);
                        bankAccount.withdraw(withdrawalAmount);
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Obrigado, " + nome + ", por utilizar o sistema. Até Mais!");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}

class BankAccount {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public BankAccount(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public void displayBalance() {
        JOptionPane.showMessageDialog(null,
                "Saldo atual para " + nome + " " + sobrenome + " (CPF: " + cpf + "): R$" + saldo);
    }

    public void deposit(double amount) {
        saldo += amount;
        JOptionPane.showMessageDialog(null,
                "Depósito de R$" + amount + " realizado com sucesso para " + nome + " " + sobrenome + ".");
        displayBalance();
    }

    public void withdraw(double amount) {
        if (saldo >= amount) {
            saldo -= amount;
            JOptionPane.showMessageDialog(null,
                    "Retirada de R$" + amount + " realizada com sucesso para " + nome + " " + sobrenome + ".");
            displayBalance();
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para a retirada.");
        }
    }
}
