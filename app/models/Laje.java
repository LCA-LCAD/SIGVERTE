package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.io.File;
import java.util.List;

/**
 * Created by ftominc on 29/04/15.
 */
@Entity
public class Laje extends Model{
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Descricao> descricao;
    /*@OneToMany(cascade = CascadeType.ALL)
    private List<File> imagens;*/
    @ManyToMany
    private List<Coleta> coletas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Descricao> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<Descricao> descricao) {
        this.descricao = descricao;
    }

    public List<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(List<Coleta> coletas) {
        this.coletas = coletas;
    }
}
