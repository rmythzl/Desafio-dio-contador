import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Digite o primeiro número inteiro: ");
                int primeiroNumero = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o segundo número inteiro: ");
                int segundoNumero = Integer.parseInt(scanner.nextLine());

                if (primeiroNumero > segundoNumero) {
                    throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
                }

                int quantidadeInteracoes = segundoNumero - primeiroNumero;

                for (int i = 1; i <= quantidadeInteracoes; i++) {
                    System.out.println("Imprimindo o número " + i);
                }

                continuar = false; // Saia do loop se tudo correr bem
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira números inteiros válidos.");
            } catch (ParametrosInvalidosException e) {
                System.out.println(e.getMessage());
            }

            // Pergunta se o usuário deseja tentar novamente
            if (continuar) {
                System.out.print("Deseja tentar novamente? (s/n): ");
                String resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("s")) {
                    continuar = false;
                }
            }
        }

        scanner.close();
        System.out.println("Programa encerrado. Obrigado por usar!");
    }

}

// Os comandos para compilar e executar o programa
javac src/Contador.java src/ParametrosInvalidosException.java -d bin

//Execute o programa com
java -cp bin Contador