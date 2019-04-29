package teste.m.bloconotasactivity;

public class Nota {
    Integer id;
    String titulo;
    String conteudo;
    boolean favorido;
    int color;

    public Nota(Integer id, String tituo, String conteudo, boolean favorido, int color) {
        this.id = id;
        this.titulo = tituo;
        this.conteudo = conteudo;
        this.favorido = favorido;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isFavorido() {
        return favorido;
    }

    public void setFavorido(boolean favorido) {
        this.favorido = favorido;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
