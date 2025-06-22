package Application;

import java.util.Scanner;

import entities.TipoConta;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String nome = "João da Silva";
		String cpf = "123.456.789-00";
		String senha = "123456";
		double saldo = 2000.00;

		int opcao = 0;

		TipoConta tipoConta = TipoConta.CONTA_CORRENTE;

		System.out.println("**************************************");
		System.out.println("     Bem-vindo ao BancoAzul!!       ");
		System.out.println("**************************************");
		System.out.println("Nome do cliente : " + nome);
		System.out.println("CPF do cliente : " + cpf);

		// Validação de senha
		System.out.print("Digite sua senha: ");
		String senhaDigitada = scanner.nextLine();

		if (!senhaDigitada.equals(senha)) {
			System.out.println("**************************************");
			System.out.println("        Senha incorreta!            ");
			System.out.println("      Programa encerrado.           ");
			System.out.println("**************************************");
			scanner.close();
			return;
		}

		System.out.println("\nLogin bem-sucedido!");
		System.out.println("Tipo Conta: " + tipoConta.getDescricao());
		System.out.println("**************************************\n");

		String menu = """
				** Menu Principal **
				1 - Visualizar Saldo
				2 - Transferir
				3 - Depositar
				4 - Mudar Tipo de Conta
				5 - Sair

				""";

		// Loop principal do menu
		while (opcao != 5) {
			System.out.println(menu);
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Consome a quebra de linha

			System.out.println("--------------------------------------");

			// Processa a opção escolhida
			switch (opcao) {
			case 1: // Visualizar Saldo
				System.out.println("Você escolheu: Visualizar Saldo.");
				System.out.printf("Seu saldo atual é: R$ %.2f%n", saldo);
				break;

			case 2: // Transferir
				System.out.println("Você escolheu: Transferir.");
				System.out.print("Digite o valor a ser transferido: R$ ");
				double valorTransferencia = scanner.nextDouble();
				scanner.nextLine(); // Consome a quebra de linha

				if (valorTransferencia <= 0) {
					System.out.println("O valor da transferência deve ser positivo. Operação não realizada.");
				} else if (valorTransferencia > saldo) {
					System.out.println("Saldo insuficiente para transferência.");
					System.out.printf("Operação não realizada. Saldo atual: R$ %.2f%n", saldo);
				} else {
					saldo -= valorTransferencia;
					System.out.printf("Transferência de R$ %.2f realizada com sucesso!%n", valorTransferencia);
					System.out.printf("Novo saldo: R$ %.2f%n", saldo);
				}
				break;

			case 3: // Depositar
				System.out.println("Você escolheu: Depositar.");
				System.out.print("Digite o valor a ser depositado: R$ ");
				double valorRecebido = scanner.nextDouble();
				scanner.nextLine(); // Consome a quebra de linha

				if (valorRecebido <= 0) {
					System.out.println("Valor inválido para depósito.");
				} else {
					saldo += valorRecebido;
					System.out.println(
							"Depósito de R$ " + String.format("%.2f", valorRecebido) + " realizado com sucesso!");
					System.out.printf("Seu novo saldo é: R$ %.2f%n", saldo);
				}
				break;

			case 4: // Mudar Tipo de Conta
				System.out.println("Você escolheu: Mudar Tipo de Conta.");
				System.out.println("Escolha o novo tipo de conta:");
				for (TipoConta tipo : TipoConta.values()) {
					System.out.println(tipo.ordinal() + 1 + " - " + tipo.getDescricao());
				}
				System.out.print("Digite o número da nova conta: ");
				int novoTipoContaNum = scanner.nextInt();
				scanner.nextLine(); // Consome a quebra de linha

				if (novoTipoContaNum < 1 || novoTipoContaNum > TipoConta.values().length) {
					System.out.println("Opção inválida. Tipo de conta não alterado.");
				} else {
					tipoConta = TipoConta.values()[novoTipoContaNum - 1];
					System.out.println("Tipo de conta alterado para: " + tipoConta.getDescricao());
				}
				break;

			case 5: // Sair
				System.out.println("Você escolheu sair do sistema.");
				System.out.println("Obrigado por usar o BancoAzul!");
				break;

			default: // Opção inválida
				System.out.println("Opção inválida. Por favor, escolha uma opção válida entre 1 e 5.");
				break;
			}
			System.out.println("**************************************\n");
		}

		scanner.close(); // Fecha o scanner
	}
}
