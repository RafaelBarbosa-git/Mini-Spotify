import java.time.Duration;
import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Midias> listaDeMidias;

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

    public void listarMidias(){
        for (Midias midia : listaDeMidias){
            System.out.println("- " + midia.toString());
        }
    }
    public void quantidadeDeMidias(){
        System.out.println("Número de mídias: " + listaDeMidias.size());
    }

    public Duration duracaoTotal(){
        Duration duracaoTotal = Duration.ofHours(0);
        for (Midias midia : this.listaDeMidias){
            duracaoTotal.plus(midia.getDuracao());
        }
        return duracaoTotal;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "nome='" + nome + '\'' +
                ", listaDeMidias=" + listaDeMidias +
                '}';
    }
}
