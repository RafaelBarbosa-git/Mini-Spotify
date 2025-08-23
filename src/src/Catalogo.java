import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// funções e lista de mídias
//adicionar tratamentos de erro
public class Catalogo {
    ArrayList<Midias> midias = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int login(){
        System.out.print("___BEM-VINDO___" +
                "\nEntre em uma conta para ouvir seus sons!" +
                "\n1- Criar nova conta" +
                "\n2- Entrar em uma conta já existente" +
                "\n3- Sair do app" +
                "\nDigite a opção correspondente: ");
        int sairDoApp = scanner.nextInt();
        return sairDoApp;
    }
    void criarUsuario(){
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = scanner.nextLine();
        // criar usuario
        System.out.println("Usúário cadastrado com sucesso!");

    }
    int menu(){
        int opcao = 1;
        return opcao;
    }
}
