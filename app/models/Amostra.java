package models;

import models.utils.Point;
import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by ftominc on 29/04/15.
 */
@Entity
public class Amostra extends Model {
    @Id
    private Long Id;
    private Date dataInsercao;
    private Date dataExclusao;
    private Date dataColeta;
    private String Descricao;
    private Point coordenada;
    /*@OneToMany(cascade = CascadeType.ALL)
    private List<File> imagens;
    @OneToMany(cascade = CascadeType.ALL)
    private List<String> comentarios;*/

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }
}
