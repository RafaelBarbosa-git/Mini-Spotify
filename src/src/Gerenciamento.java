import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gerenciamento {
    Catalogo catalogo;
    HashMap<String, Usuario> usuarios = new HashMap<>();

    Scanner scanner = new Scanner(System.in);
    int login(){
        System.out.print("___BEM-VINDO___" +
                "\nEntre em uma conta para ouvir seus sons!" +
                "\n1- Criar nova conta" +
                "\n2- Entrar em uma conta já existente" +
                "\n3- Sair do app" +
                "\nDigite a opção correspondente: ");
        int sairDoApp = scanner.nextInt();
        scanner.nextLine();
        return sairDoApp;
    }
    void criarUsuario(){
        catalogo = new Catalogo();
        ArrayList<Playlist> listadePlaylists = new ArrayList<>();
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = scanner.nextLine();
        // usar tratamento de erro para email já existente
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario, catalogo, listadePlaylists);
        usuarios.put(emailUsuario, usuario);
        System.out.println("Usúário cadastrado com sucesso!");
        //ir para o menu do usuario
    }
    int menu(){
        System.out.print("O que deseja?" +
                "\n1- Criar uma playlist" +
                "\n2- Ver suas Playlists" +
                "\n3- Escolher playlist" +
                "\n4- Ver suas mídias" +
                "\n5- Pesquisar mídias" +
                "\n6- Sair da conta");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    void escolherUsuario(){
        if (!(usuarios.isEmpty())){
            System.out.println("Contas Disponiveis:");
            for (Usuario conta : usuarios.values()){
                System.out.println(conta.toString());
            }
            System.out.print("Digite o email da conta que deseja: ");
            String emailEscolhido = scanner.nextLine();
            // falta tratamento de erro
            for (Usuario usuarioEscolhido : usuarios.values()){
                if (usuarioEscolhido.getEmail().equals(emailEscolhido)){
                    System.out.println("Bem vindo(a) "+ usuarioEscolhido.getNome());
                }
            }
        } else {
            System.out.println("Ainda não há usuários registrados!");
        }
    }
}
