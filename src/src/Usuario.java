import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Playlist> playlists = new ArrayList<>();

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + " (" + email + ")";
    }
}

