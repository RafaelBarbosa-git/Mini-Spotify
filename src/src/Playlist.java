import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList lista;

    public Playlist(String nome, ArrayList midias) {
        this.nome = nome;
        this.lista = midias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
