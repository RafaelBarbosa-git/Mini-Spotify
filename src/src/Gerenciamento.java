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
    boolean escolherUsuario() {
        boolean existeUsuario = false;
        if (!(usuarios.isEmpty())) {
            System.out.println("Contas Disponiveis:");
            for (Usuario conta : usuarios.values()) {
                System.out.println(conta.toString());
            }
            System.out.print("Digite o email da conta que deseja: ");
            String emailEscolhido = scanner.nextLine();
            // falta tratamento de erro
            for (Usuario usuarioEscolhido : usuarios.values()) {
                if (usuarioEscolhido.getEmail().equals(emailEscolhido)) {
                    System.out.println("Bem vindo(a) " + usuarioEscolhido.getNome());
                    this.catalogo = usuarioEscolhido.getCatalogo();
                }
            }
        } else {
            System.out.println("Ainda não há usuários registrados!");
            existeUsuario = false;
        }
        return existeUsuario;
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
        {
            ArrayList<Playlist> playlists = catalogo.getTodasPlaylists();
            if (playlists.isEmpty()) {
                System.out.println("Você ainda não tem playlists.");
                return;
            }

            System.out.print("Digite o nome da playlist que deseja visualizar: ");
            String nomePlaylist = scanner.nextLine();

            Playlist encontrada = null;
            for (Playlist p : playlists) {
                if (p.getNome().equalsIgnoreCase(nomePlaylist)) {
                    encontrada = p;
                    break;
                }
            }

            if (encontrada == null) {
                System.out.println("Playlist não encontrada.");
                return;
            }

            ArrayList<Midias> midias = encontrada.getListaDeMidias();
            System.out.println("Playlist: " + encontrada.getNome());
            System.out.println("Número de mídias: " + midias.size());

            int duracaoTotal = 0;
            if (midias.isEmpty()) {
                System.out.println("A playlist está vazia.");
            } else {
                for (Midias m : midias) {
                    System.out.println("- " + m.toString());
                    try {
                        duracaoTotal += Integer.parseInt(m.getDuracao());
                    } catch (NumberFormatException e) {
                        System.out.println("(Erro ao calcular duração de: " + m.getTitulo() + ")");
                    }
                }
                System.out.println("Duração total: " + duracaoTotal + " minutos");
            }

            System.out.print("O que deseja fazer agora?\n1 - Adicionar mídia\n2 - Remover mídia\n3 - Voltar\nDigite: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMidiaAPlaylist(encontrada);
                    break;
                case 2:
                    removerMidiaDePlaylist(encontrada);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

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
    void verSuasMidias(){//verSuasMidias;;
        ArrayList<Midias> midias = catalogo.getTodasMidias();
            if (midias.isEmpty()) {
                System.out.println("Você ainda não adicionou nenhuma mídia.");
            } else {
                System.out.println("=== Suas Mídias ===");
                for (int i = 0; i < midias.size(); i++) {
                    System.out.println((i + 1) + "- " + midias.get(i).getTitulo());
                int escolhendoMidia;
                do{
                System.out.println("Deseja escolher alguma midia?" +
                        "\n1- Sim" +
                        "\n2- Não" +
                        "\nDigite sua opção");
                escolhendoMidia = scanner.nextInt();
                switch (escolhendoMidia){
                    case 1:
                        escolherMidia(midias);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opção inválida! Tente Novamente.");
                }
                }while (escolhendoMidia != 2);
            }
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();
        }
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
            System.out.println("Classe: " + midiaEscolhida.getClasse());
        } else {
            System.out.println("Opção inválida!");
        }

        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }
    }

