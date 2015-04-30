package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ftominc on 29/04/15.
 */
@Entity
public class Coleta  extends Model{
    @Id
    private Long id;
    private String tipo;
    private Date data;
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Amostra> amostras;
    @ManyToMany
    private List<Laje> lajes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Amostra> getAmostras() {
        return amostras;
    }

    public void setAmostras(List<Amostra> amostras) {
        this.amostras = amostras;
    }

    public List<Laje> getLajes() {
        return lajes;
    }

    public void setLajes(List<Laje> lajes) {
        this.lajes = lajes;
    }
}
