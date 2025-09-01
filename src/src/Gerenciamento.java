import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
// lembrar a duração total das playlists. Onde aparecerá esse dado?
public class Gerenciamento {
    Catalogo catalogo;
    HashMap<String, Usuario> usuarios = new HashMap<>();

    Scanner scanner = new Scanner(System.in);
    private Object playlist;

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
                "\n6- Sair da conta" +
                "\nDigite sua opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    boolean escolherUsuario() throws EmailJaUsadoException{
        boolean existeUsuario = false;
        Usuario usuario = null;
        if (!(usuarios.isEmpty())) {
            System.out.println("Contas Disponiveis:");
            for (Usuario conta : usuarios.values()) {
                System.out.println(conta.toString());
            }
            System.out.print("Digite o email da conta que deseja: ");
            String emailEscolhido = scanner.nextLine();
            if (!emailEscolhido.contains("@")){
                throw new EmailJaUsadoException("O email precisa ter '@'!");
            }
            for (Usuario usuarioEscolhido : usuarios.values()) {
                if (usuarioEscolhido.getEmail().equals(emailEscolhido)) {
                    System.out.println("Bem vindo(a) " + usuarioEscolhido.getNome());
                    usuario = usuarioEscolhido;
                }
            }
        } else {
            System.out.println("Ainda não há usuários registrados!");
            existeUsuario = false;
        }
        System.out.println(usuario);
        return existeUsuario;
    }


    // como garantir que essas funções usem o catalogo do usuario certo, no caso de troca de usuário?
    void criarPlaylist() throws NomeDePlaylistJaUsadoException {
        System.out.print("Digite o nome da playlist que deseja criar: ");
        String nomeDaPlaylist = scanner.nextLine();
        for (Playlist playlist : catalogo.getTodasPlaylists()){
            if (playlist.getNome().equalsIgnoreCase(nomeDaPlaylist)){
                throw new NomeDePlaylistJaUsadoException("Este nome de playlist já esta sendo usado!");
            }
        }
        ArrayList<Midias> playlistNova = new ArrayList<>();
        Playlist playlistCriada = new Playlist(nomeDaPlaylist, playlistNova);
        catalogo.adicionarPlaylist(playlistCriada);
        System.out.println("Playlist criada com sucesso!");
    }
    void verPlaylists() {
        ArrayList<Playlist> listaDePlaylist = catalogo.getTodasPlaylists();
        if (listaDePlaylist.isEmpty()){
            System.out.println("A lista ainda está vazia!");
        }else {
            for (Playlist playlistListada : listaDePlaylist) {
                System.out.println("- " + playlistListada.getNome());
            }
            int opcaoEsReVo = 0;
            do {
                try {
                    System.out.print("O que deseja?" +
                            "\n1- Escolher playlist" +
                            "\n2- remover playlist" +
                            "\n3- voltar" +
                            "\nDigite o que deseja: ");
                    opcaoEsReVo = scanner.nextInt();
                }catch (NumberFormatException e){
                    System.out.println("Opção inválida! Digite apenas números inteiros de 1 a 3!");
                }
                switch (opcaoEsReVo){
                    case 1:
                        escolherPlaylist();
                    case 2:
                        removerPlaylist();
                    case 3:
                        System.out.println("Opção inválida! Digite apenas números inteiros de 1 a 3!");
                }
            }while (opcaoEsReVo != 3);
        }
    }
    void adicionarMidia() throws CampoSemLetrasException {

        System.out.print("Digite o título da mídia: ");
        String titulo = scanner.nextLine();


        System.out.print("Digite o artista: ");
        String artista = scanner.nextLine();
        if (!artista.matches(".*[a-zA-Z].*")) {
            throw new CampoSemLetrasException("Nome inválido! Não contém letras.");
        }

        String duracao = "";
        while (true) {
            System.out.print("Digite a duração (HH:MM:SS): ");
            duracao = scanner.nextLine();
            if (duracao.matches("\\d{2}:\\d{2}:\\d{2}")) {
                break; // saiu do loop se estiver correto
            } else {
                System.out.println("Formato inválido! Use HH:MM:SS. Tente novamente.");
            }
        }

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

        Midias novaMidia = null;
        int tipo = 0;

        while (tipo < 1 || tipo > 3) {
            try {
                System.out.println("Escolha o tipo de mídia:");
                System.out.println("1 - MUSICA");
                System.out.println("2 - AUDIOBOOK");
                System.out.println("3 - PODCAST");
                System.out.print("Digite sua opção: ");
                tipo = scanner.nextInt();
                scanner.nextLine();
            }catch (NumberFormatException e){
                System.out.println("Opção inválida! Digite apenas números.");
            }
            if (tipo < 1 || tipo > 3) {
                System.out.println("Opção inválida! Digite 1, 2 ou 3.");
            }
        }

        switch (tipo) {
            case 1:
                novaMidia = new Musica(titulo, artista, duracao, genero);
                break;
            case 2:
                novaMidia = new AudioBook(titulo, artista, duracao, genero);
                break;
            case 3:
                novaMidia = new Podcast(titulo, artista, duracao, genero);
                break;
        }


        catalogo.adicionarMidias(novaMidia);
        System.out.println("Mídia adicionada com sucesso: " + novaMidia.toString());

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    void escolherPlaylist(){
        ArrayList<Playlist> playlists = catalogo.getTodasPlaylists();
            System.out.print("Digite o nome da playlist que deseja visualizar: ");
            String nomePlaylist = scanner.nextLine();

            Playlist playlistEncontrada = null;
            for (Playlist p : playlists) {
                if (p.getNome().equalsIgnoreCase(nomePlaylist)) {
                    playlistEncontrada = p;
                    break;
                }
            }
            if (playlistEncontrada == null) {
                System.out.println("Playlist não encontrada.");
                return;
            }
            else {
                System.out.println("Playlist: " + playlistEncontrada.getNome());
                playlistEncontrada.quantidadeDeMidias();

                Duration duracaoTotal;
                if (playlistEncontrada.getListaDeMidias().isEmpty()) {
                    System.out.println("A playlist está vazia.");
                } else {
                    System.out.println("Duração total da playlist: " + playlistEncontrada.duracaoTotal());
                    playlistEncontrada.listarMidias();
                    }
                }

                System.out.print("\nO que deseja fazer agora?\n1 - Adicionar mídia à playlist\n2 - Remover mídia da playlist\n3 - Voltar\nDigite: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarMidiaAPlaylist(playlistEncontrada);
                        break;
                    case 2:
                        removerMidiaDePlaylist(playlistEncontrada);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
    }
    void removerPlaylist(){
        //falta fazer
    }

    private void adicionarMidiaAPlaylist(Playlist encontrada) {
    }

    void removerMidiaDePlaylist(Playlist playlist){
        {
            ArrayList<Midias> midias = playlist.getListaDeMidias();
            if (midias.isEmpty()) {
                System.out.println("A playlist está vazia.");
                return;
            }

            System.out.println("Mídias da playlist:");
            for (int i = 0; i < midias.size(); i++) {
                System.out.println((i + 1) + " - " + midias.get(i).getTitulo());
            }

            System.out.print("Digite o número da mídia que deseja remover: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 0 && escolha <= midias.size()) {
                Midias removida = midias.remove(escolha - 1);
                System.out.println("Mídia removida: " + removida.getTitulo());
            } else {
                System.out.println("Opção inválida.");
            }
        }

    }
    void verSuasMidias(){
            if (catalogo.getTodasMidias().isEmpty()) {
                System.out.println("Você ainda não adicionou nenhuma mídia.");
            } else {
                int opcaoEsReVo = 0;
                    do {
                        try {
                            catalogo.listarMidias();
                            System.out.print("\nO que deseja?" +
                                    "\n1- Escolher mídia" +
                                    "\n2- remover mídia do catalógo" +
                                    "\n3- voltar" +
                                    "\nDigite o que deseja: ");
                            opcaoEsReVo = scanner.nextInt();
                        }catch (NumberFormatException e){
                            System.out.println("Opção inválida! Digite apenas números inteiros de 1 a 3!");
                        }
                        switch (opcaoEsReVo){
                            case 1:
                                escolherPlaylist();
                            case 2:
                                System.out.print("Digite o número da midia que deseja remover: ");
                                int midiaRemover = scanner.nextInt();
                            case 3:
                                System.out.println("Opção inválida! Digite apenas números inteiros de 1 a 3!");
                        }
                    }while (opcaoEsReVo != 3);

            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();
        }
    }

    void pesquisarMidias(){
        System.out.println("Pesquisar por:");
        System.out.println("1 - Nome da mídia");
        System.out.println("2 - Artista");
        System.out.println("3 - Gênero");
        System.out.print("Digite sua opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o termo da pesquisa: ");
        String termo = scanner.nextLine().toLowerCase();

//        ArrayList<Midias> todasMidias = catalogo.getTodasMidias();
        int contador = 0;

        for (Midias midia : catalogo.getTodasMidias()) {
            if (opcao == 1 && midia.getTitulo().toLowerCase().contains(termo)) {
                System.out.println(midia.toString());
                contador++;
            } else if (opcao == 2 && midia.getArtista().toLowerCase().contains(termo)) {
                System.out.println(midia.toString());
                contador++;
            } else if (opcao == 3 && midia.getGenero().toString().toLowerCase().contains(termo)) {
                System.out.println(midia.toString());
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("Nenhuma mídia encontrada com esse termo.");
        }

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    void escolherMidia(ArrayList<Midias> listaDeMidias){

//        System.out.println("Suas mídias:");
//        for (int i = 0; i < listaDeMidias.size(); i++) {
//            System.out.println((i + 1) + " - " + listaDeMidias.get(i).getTitulo());
//        }

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
        } else {
            System.out.println("Opção inválida!");
        }

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }
    }

