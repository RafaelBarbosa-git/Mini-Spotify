import java.util.ArrayList;
import java.util.Scanner;

//adicionar tratamentos de erro
public class Catalogo {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Midias> midias = new ArrayList<>();
//    System.out.print("O que deseja?" +
//            "\n1- Criar uma playlist" +
//            "\n2- Ver suas Playlists" +
//            "\n3- Escolher playlist" +
//            "\n4- Ver suas mídias" +
//            "\n5- Pesquisar mídias" +
//            "\n6- Sair da conta");
    void criarPlaylist(){
        System.out.print("Digite o nome da playlist que deseja criar: ");
        String nomeDaPlaylist = scanner.nextLine();
        // tratamento de erro
        ArrayList<Midias> playlistNova = new ArrayList<>();
        Playlist playlistCriada = new Playlist(nomeDaPlaylist, playlistNova);
        System.out.println("Playlist criada com sucesso!");
    }
    void verPlaylists(){
    }
    }

