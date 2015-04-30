package models;

import play.db.ebean.Model;

import javax.jws.Oneway;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by ftominc on 29/04/15.
 */
@Entity
public class Calha extends Model {
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<DadoHistorico> dadosHistoricos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Laje> lajes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DadoHistorico> getDadosHistoricos() {
        return dadosHistoricos;
    }

    public void setDadosHistoricos(List<DadoHistorico> dadosHistoricos) {
        this.dadosHistoricos = dadosHistoricos;
    }

    public List<Laje> getLajes() {
        return lajes;
    }

    public void setLajes(List<Laje> lajes) {
        this.lajes = lajes;
    }
}
