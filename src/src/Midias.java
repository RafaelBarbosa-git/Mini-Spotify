import java.time.Duration;

public class Midias{
    private String titulo;
    private String artista;
    private Duration duracao;
    private Genero genero;

    public Midias(String titulo, String artista, Duration duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getDuracao() {
        return duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracao + " min, " + genero + ")";
    }
}
