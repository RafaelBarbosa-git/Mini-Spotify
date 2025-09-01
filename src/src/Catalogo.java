import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Midias> todasMidias;
    private ArrayList todasPlaylists;

    public Catalogo(ArrayList midias, ArrayList playlists) {
        this.todasMidias = midias;
        this.todasPlaylists = playlists;
    }

    public ArrayList<Midias> getTodasMidias() {
        return todasMidias;
    }

    public ArrayList<Playlist> getTodasPlaylists() {
        return todasPlaylists;
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
        todasMidias.add(novaMidia);
    }
    public void listarMidias(){
        for (Midias midias : this.todasMidias){
            System.out.println("=== Suas Mídias ===");
            for (int i = 0; i < todasMidias.size(); i++) {
                System.out.println((i + 1) + "- " + todasMidias.get(i).getTitulo());
            }
        }
    }
}

