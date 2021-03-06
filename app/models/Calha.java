package models;

import play.db.ebean.Model;

import javax.jws.Oneway;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.File;
import java.util.List;

/**
 * Created by RSenger on 29/04/15.
 */
@Entity
public class Calha extends Model {
    @Id
    private Character id;
    private String dadosHistoricos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Laje> lajes;

    private File imagem;

    private File getImagem() {
        return imagem;
    }

    private void setImagem(File imagem){
        this.imagem = imagem;
    }

    public Character getId() {
        return id;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public String getDadosHistoricos() {
        return dadosHistoricos;
    }

    public void setDadosHistoricos(String dadosHistoricos) {
        this.dadosHistoricos = dadosHistoricos;
    }

    public List<Laje> getLajes() {
        return lajes;
    }

    public void setLajes(List<Laje> lajes) {
        this.lajes = lajes;
    }
}
