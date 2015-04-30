package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ftominc on 4/30/15.
 */
@Entity
public class DadoHistorico extends Model{
    @Id
    private Long id;
    private String dadoHistorico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDadoHistorico() {
        return dadoHistorico;
    }

    public void setDadoHistorico(String dadoHistorico) {
        this.dadoHistorico = dadoHistorico;
    }
}
