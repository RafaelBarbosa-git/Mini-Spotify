import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
// lembrar a duração total das playlists. Onde aparecerá esse dado?
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
        ArrayList<Midias> todasMidias = new ArrayList<>();
        ArrayList<Playlist> todasPlaylists = new ArrayList<>();
        catalogo = new Catalogo(todasMidias, todasPlaylists);
        ArrayList<Playlist> listadePlaylists = new ArrayList<>();
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = scanner.nextLine();
        // usar tratamento de erro para email já existente
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario, catalogo);
        usuarios.put(emailUsuario, usuario);
        System.out.println("Usúário cadastrado com sucesso!");
        //ir para o menu do usuario
    }
    int menu(){
        System.out.print("O que deseja?" +
                "\n1- Criar uma playlist" +
                "\n2- Ver suas Playlists" +
                "\n3- Adicionar uma mídia" +
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


    // como garantir que essas funções usem o catalogo do usuario certo, no caso de troca de usuário?
    void criarPlaylist(){
        System.out.print("Digite o nome da playlist que deseja criar: ");
        String nomeDaPlaylist = scanner.nextLine();
        // tratamento de erro
        ArrayList<Midias> playlistNova = new ArrayList<>();
        Playlist playlistCriada = new Playlist(nomeDaPlaylist, playlistNova);
        catalogo.adicionarPlaylist(playlistCriada);
        System.out.println("Playlist criada com sucesso!");
    }
    void verPlaylists(){
        ArrayList<Playlist> listaDePlaylist = catalogo.getTodasPlaylists();
        if (listaDePlaylist.isEmpty()){
            System.out.println("A lista ainda está vazia!");
        }else {
            for (Playlist playlistListada : listaDePlaylist) {
                System.out.println("- " + playlistListada.getNome());
            }
            //adicionar loop do-while a seguir
            System.out.print("O que deseja?" +
                    "\n1- Escolher playlist" +
                    "\n2- remover playlist" +
                    "\n3- voltar");
            //continuar código
        }
    }
    void adicionarMidia(){
        //falta fazer
        // cria uma midia e adiciona no catalogo
        }
    void escolherPlaylist(){
        //falta fazer
        // Será usado dentro do metodo "ver suas playlists"
        //pede o nome da playlist. se tiver, diz a duração total da playlist, lista as midias dela e
        // dá a opção de adicionar ou remover música da playlist
        //notificar caso ainda não tenham playlist ou se não tiver playlist com o nome dado
    }
    void removerMidiaDePlaylist(){
        //falta fazer
        //remove a midia de determinada playlist
    }
    void verSuasMidias(){
        //falta fazer
        // lista todas as midias
    }
    void pesquisarMidias(){
        //falta fazer
        // pergunta se quer pesquisar por nome, por artista ou por gênero
    }
    void escolherMidia(){
        //falta fazer
        //permitirá escolher uma midia e mostrar todos os dados de tal midia
        //deixar para fazer só no final
    }
}
