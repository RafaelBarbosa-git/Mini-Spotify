public class Midias{
    private String titulo;
    private String artista;
    private String duracao;
    private Genero genero;
    private Classe classe;

    public Midias(String titulo, String artista, String duracao, Genero genero, Classe classe) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
        this.classe = classe;
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
    public Classe getClasse() {
        return classe;
    }
}
