import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList listaDeMidias;

    public Playlist(String nome, ArrayList midias) {
        this.nome = nome;
        this.listaDeMidias = midias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList getListaDeMidias() {
        return listaDeMidias;
    }
}
