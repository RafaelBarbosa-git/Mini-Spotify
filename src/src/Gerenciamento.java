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
                "\n6- Escolher uma mídia" +
                "\n7- Sair da conta");

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

                    this.catalogo = usuarioEscolhido.getCatalogo();

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
            System.out.print("Digite o título da mídia: ");
            String titulo = scanner.nextLine();

            System.out.print("Digite o artista: ");
            String artista = scanner.nextLine();

            System.out.print("Digite a duração (em minutos): ");
            String duracao = scanner.nextLine();

            Genero genero = null;
            while (genero == null) {
                System.out.print("Digite o gênero (ROCK, POP, MPB, JAZZ, CLASSICA, ELETRONICA, HIPHOP, RAP, SAMBA, PAGODE, FUNK, REGGAE): ");
                String generoStr = scanner.nextLine().toUpperCase();
                try {
                    genero = Genero.valueOf(generoStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Gênero inválido! Tente novamente.");
                }
            }

            Classe classe = null;
            while (classe == null) {
                System.out.print("Digite a classe (ex: AUDIOBOOK, MUSICA ou PODCAST): ");
                String classeStr = scanner.nextLine().toUpperCase();
                try {
                    classe = Classe.valueOf(classeStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Classe inválida! Tente novamente.");
                }
            }

            Midias novaMidia = new Midias(titulo, artista, duracao, genero, classe);
            catalogo.adicionarMidias(novaMidia);

            System.out.println("Mídia adicionada com sucesso: " + novaMidia.toString());

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();


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
        // falta fazer
    }
    void pesquisarMidias(){
        System.out.println("Pesquisar por:");
        System.out.println("1 - Nome da mídia");
        System.out.println("2 - Artista");
        System.out.println("3 - Gênero");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o termo da pesquisa: ");
        String termo = scanner.nextLine().toLowerCase();

        ArrayList<Midias> todasMidias = catalogo.getTodasMidias();
        int contador = 0;

        for (Midias midia : todasMidias) {
            if (opcao == 1 && midia.getTitulo().toLowerCase().contains(termo)) {
                System.out.println(midia);
                contador++;
            } else if (opcao == 2 && midia.getArtista().toLowerCase().contains(termo)) {
                System.out.println(midia);
                contador++;
            } else if (opcao == 3 && midia.getGenero().toString().toLowerCase().contains(termo)) {
                System.out.println(midia);
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("Nenhuma mídia encontrada com esse termo.");
        }

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    void escolherMidia(){
        ArrayList<Midias> listaDeMidias = catalogo.getTodasMidias();

        if (listaDeMidias.isEmpty()) {
            System.out.println("Você ainda não tem mídias adicionadas!");
            return;
        }

        System.out.println("Suas mídias:");
        for (int i = 0; i < listaDeMidias.size(); i++) {
            System.out.println((i + 1) + " - " + listaDeMidias.get(i).getTitulo());
        }

        System.out.print("Digite o número da mídia que deseja ver: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // consumir quebra de linha

        if (escolha > 0 && escolha <= listaDeMidias.size()) {
            Midias midiaEscolhida = listaDeMidias.get(escolha - 1);
            System.out.println("=== Detalhes da mídia ===");
            System.out.println("Título: " + midiaEscolhida.getTitulo());
            System.out.println("Artista: " + midiaEscolhida.getArtista());
            System.out.println("Duração: " + midiaEscolhida.getDuracao() + " min");
            System.out.println("Gênero: " + midiaEscolhida.getGenero());
            System.out.println("Classe: " + midiaEscolhida.getClasse());
        } else {
            System.out.println("Opção inválida!");
        }

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }
    }

