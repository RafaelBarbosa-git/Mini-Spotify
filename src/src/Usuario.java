import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Midias> midias = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    public void adicionarMidia(Midias midia) {
        midias.add(midia);
    }

    @Override
    public String toString() {
        return "Playlist: " + nome + " | " + midias.size() + " mídias";
    }

    public void removerMidia(String tituloRemover) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerMidia'");
    }

    public void exibirPlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirPlaylist'");
    }
}
