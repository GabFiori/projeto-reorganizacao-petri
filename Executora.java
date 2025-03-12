import java.util.Scanner;
public class Executora {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();


//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();
//        arvoreBinaria.inserir();



        int escolha = 0;
        int escolha2 = 0;
        int opcao = 100;
        while (opcao != 6) {
            System.out.println(" 1-Remover\n 2-PréOrdem\n 3-EmOrdem\n 4-PosOrdem\n 5-Inserir\n 6-Encerrar");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Insira qual nó quer remover: ");
                    escolha = teclado.nextInt();
                    arvoreBinaria.remover(escolha);
                    break;
                case 2:
                    System.out.println("Imprimindo árvore PréOrdem...");
                    arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                    break;
                case 3:
                    System.out.println("Imprimindo árvore EmOrdem...");
                    arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
                    break;
                case 4:
                    System.out.println("Imprimindo árvore PósOrdem...");
                    arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
                    break;
                case 5:
                    System.out.println("Qual nó quer inserir?");
                    escolha2 = teclado.nextInt();
                    arvoreBinaria.inserir(escolha2);
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
            }
        }
    }
}

/*Problemas Identificados e Melhorias
Código comentado desnecessário

Há várias chamadas de arvoreBinaria.inserir() comentadas que podem ser removidas.
Uso de variáveis desnecessárias

escolha e escolha2 servem ao mesmo propósito. Podemos usar apenas uma variável para armazenar a entrada do usuário.
Scanner não fechado

Scanner teclado deve ser fechado no final para evitar vazamento de recursos.
Loop while pode ser simplificado

O código pode ser reestruturado para maior legibilidade, evitando o uso de opcao = 100; inicialmente.
Adicionar um default no switch-case

Para tratar entradas inválidas do usuário.*/

//Nova classe executora

/*import java.util.Scanner;

public class Executora {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Remover");
            System.out.println("2 - Pré-Ordem");
            System.out.println("3 - Em Ordem");
            System.out.println("4 - Pós-Ordem");
            System.out.println("5 - Inserir");
            System.out.println("6 - Encerrar");
            System.out.print("Opção: ");

            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser removido: ");
                    int removerValor = teclado.nextInt();
                    arvoreBinaria.remover(removerValor);
                    break;
                case 2:
                    System.out.println("Imprimindo árvore em Pré-Ordem...");
                    arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                    break;
                case 3:
                    System.out.println("Imprimindo árvore em Ordem...");
                    arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
                    break;
                case 4:
                    System.out.println("Imprimindo árvore em Pós-Ordem...");
                    arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
                    break;
                case 5:
                    System.out.print("Digite o valor a ser inserido: ");
                    int inserirValor = teclado.nextInt();
                    arvoreBinaria.inserir(inserirValor);
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        teclado.close(); // Fechando o Scanner
    }
}*/
