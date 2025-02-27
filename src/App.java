import java.util.Scanner;

import implementacoes.Iphone;

public class App {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        int opcao = 0;
        Iphone iphone = new Iphone();
        do {
            opcao = selecionarOpcao(sc);

            switch (opcao) {
                case 1:
                    reprodutorMusicas(iphone);
                    break;
                case 2:
                    ligacoes(iphone, sc);
                    break;
                case 3:
                    navegarNaInternet(iphone, sc);
                    break;
                default:
                    print("Saindo...");
                    break;
            }

        } while (opcao != 0);
    }

    static void print(String str) {
        System.out.println(str);
    }

    static void ligacoes(Iphone iphone, Scanner sc) {
        print("=======================");
        print("Opções do menu Telefone: ");
        print(" 1 - Ligar");
        print(" 2 - Atender");
        print(" 3 - Correio de Voz\n");
        print("Digite a opção desejada do menu Telefone:");
        int opcaoSelecionadaTelefone = sc.nextInt();
        if (opcaoSelecionadaTelefone == 1) {
            print("Selecione um contato:");
            int n = 1;
            for (String contato : iphone.getContatos()) {
                print(n++ + " - " + contato);
            }
            int numContato;
            do {
                System.out.print("Digite número do contato: ");
                sc.nextLine();
                numContato = sc.nextInt();
            } while (numContato <= 0 || numContato > iphone.getContatos().size());

            String contato = iphone.getContatos().get(--numContato);

            iphone.ligar(contato);
        } else if (opcaoSelecionadaTelefone == 2) {
            iphone.atender();
        } else if (opcaoSelecionadaTelefone == 3) {
            iphone.iniciarCorreioVoz();
        }
    }

    static void navegarNaInternet(Iphone iphone, Scanner sc) {
        System.out.println("Digite a url: ");
        String pagina = sc.nextLine();
        pagina = sc.nextLine();
        iphone.exibirPagina(pagina);
    }

    static void reprodutorMusicas(Iphone iphone) {
        System.out.println("Reprodutor de músicas: ");
        iphone.selecionarMusica();
    }

    static int selecionarOpcao(Scanner sc) {
        print("Opções do menu do Iphone:");
        print(" 1 - Reprodutor de música");
        print(" 2 - Telefone");
        print(" 3 - Internet");
        print(" 0 - Desligar o aparelho");
        print("");
        print("Digite a opção desejada:");

        return sc.nextInt();
    }

}
