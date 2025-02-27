package implementacoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import interfaces.AparelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;

public class Iphone implements NavegadorInternet, AparelhoTelefonico, ReprodutorMusical {
    Scanner sc = new Scanner(System.in);

    private final List<String> contatos = Arrays.asList(
            "Gusttavo Lima",
            "Jorge",
            "Zé Neto",
            "Marília Mendonça",
            "Maiara",
            "Henrique",
            "Luan Santana",
            "Sorocaba",
            "Chitãozinho",
            "Marrone");

    public List<String> getContatos() {
        return contatos;
    }

    public void tocar(String musica) {
        System.out.printf("\nTocando a musica: %s\n\n", musica);
        System.out.print("Deseja pausar a musica? ( S - Sim ou N - Não ) ");
        char opcao = sc.next().toUpperCase().charAt(0);
        if (opcao == 'S') {
            pausar(musica);
        } else {
            tocar(musica);
        }
    }

    public void pausar(String musica) {
        System.out.println("Musica " + musica + " está pausada.");
    }

    public String selecionarMusica() {
        List<String> musicas = new ArrayList<>(Arrays.asList(
                "Sozinho",
                "Expresso 2222",
                "Águas de Março",
                "Construção",
                "Amor I Love You",
                "Travessia",
                "Baby",
                "Oceano",
                "O Tempo Não Para",
                "Adivinha o Quê"));

        System.out.println("Lista de músicas:");
        for (int i = 0; i < musicas.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, musicas.get(i));
        }

        int opcaoDesejada;
        System.out.println();
        do {
            System.out.print("Digite o número da opção da música desejada: ");
            opcaoDesejada = sc.nextInt();
        } while (opcaoDesejada <= 0 || opcaoDesejada > musicas.size());

        String musicaDesejada = musicas.get(opcaoDesejada - 1);
        tocar(musicaDesejada);

        return musicaDesejada;
    }

    public void ligar(String nome) {
        System.out.println("Discando...");
        var c = 0;
        var atendeu = false;
        do {
            c++;
            System.out.printf("Ligando para %s\n", nome);
            atendeu = tocando();
        } while (!atendeu && c < 7);
        if (atendeu) {
            System.out.printf("%s na linha\n", nome);
        } else {
            System.out.println("Chamada não atendida");
        }
    }

    public void atender() {
        System.out.println("Alô");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o correio de voz!");
    }

    public void exibirPagina(String pagina) {
        System.out.println("Exibindo a pagina : " + pagina);
        System.out.print("Deseja adicionar nova aba? ( S - Sim ou N - Não ) ");
        char opcao = sc.next().toUpperCase().charAt(0);
        if (opcao == 'S') {
            adicionarNovaAba();
        } else {
            System.out.print("Atualizar a página? ( S - Sim ou N - Não ) ");
            char atualizarpagina = sc.next().toUpperCase().charAt(0);
            if (atualizarpagina == 'S') {
                atualizarPagina(pagina);
            } else {
                System.out.println("Saindo do navegador!");
            }
        }
    }

    public void adicionarNovaAba() {
        sc.nextLine();
        System.out.println("Digite a url: ");
        String nomeDaPagina = sc.nextLine();
        exibirPagina(nomeDaPagina);

        System.out.println("Saindo do navegador!");
    }

    public void atualizarPagina(String pagina) {
        System.out.println("Atualizando a página!");

        exibirPagina(salvarPagina(pagina));
    }

    private static boolean tocando() {
        boolean atendeu = new Random().nextInt(6) % 2 == 0;
        System.out.println("Atendeu? " + (atendeu ? "sim" : "não"));
        return atendeu;
    }

    private static String salvarPagina(String pagina) {
        return pagina;
    }
}
