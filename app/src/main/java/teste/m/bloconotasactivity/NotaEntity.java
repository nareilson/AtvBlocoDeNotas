package teste.m.bloconotasactivity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "noatas")
public class NotaEntity {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

   // @ColumnInfo(name = "titulo")
    public String titulo;
    public String conteudo;
    public boolean favorido;
    public String color;

    public NotaEntity(String titulo, String conteudo, boolean favorido, String color) {
        this.titulo = titulo;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
