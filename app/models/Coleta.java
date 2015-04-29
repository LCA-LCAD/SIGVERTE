package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    @OneToMany
    private List<Amostra> amostras;
    @ManyToMany
    private List<Laje> lajes;
}
