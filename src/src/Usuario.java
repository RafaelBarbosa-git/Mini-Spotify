import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private Catalogo conta;
    private ArrayList playlists;

    public Usuario(String nome, String email, Catalogo catalogo, ArrayList playlists) {
        this.nome = nome;
        this.email = email;
        this.conta = catalogo;
        this.playlists = playlists;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }
    public ArrayList getPlaylists() {
        return playlists;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "   ;  email: " + email;
    }
//      public void criarPlaylist(String nomePlaylist) {
//        playlists.add(new Playlist(nomePlaylist));
//    }
//
//    public Playlist getPlaylist(String nome) {
//        for (Playlist p : playlists) {
//            if (p != null && p.toString().contains(nome)) {
//                return p;
//            }
//        }
//        return null;
//    }
//
//    public void exibirPlaylists() {
//        if (playlists.isEmpty()) {
//            System.out.println("Nenhuma playlist criada ainda.");
//        } else {
//            for (Playlist p : playlists) {
//                p.exibirPlaylist();
//            }
//        }
//    }
}
