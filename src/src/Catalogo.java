import java.util.ArrayList;

public class Catalogo {
    private ArrayList todasMidias;
    private ArrayList todasPlaylists;

    public Catalogo(ArrayList midias, ArrayList playlists) {
        this.todasMidias = midias;
        this.todasPlaylists = playlists;
    }

    public ArrayList getTodasMidias() {
        return todasMidias;
    }

    public ArrayList getTodasPlaylists() {
        return todasPlaylists;
    }
    public void adicionarMidia(Midias midia){
        todasMidias.add(midia);
    }
    public void adicionarPlaylist(Playlist playlist){
        todasPlaylists.add(playlist);
    }
    public void removerMidia(Midias midia){
        todasMidias.remove(midia);
    }
    public void removerPlaylist(Playlist playlist){
        todasPlaylists.remove(playlist);
    }

    public void adicionarMidias(Midias novaMidia) {
    }
}

