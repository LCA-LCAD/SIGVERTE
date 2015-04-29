package models;

import play.db.ebean.Model;

import javax.jws.Oneway;
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
    @OneToMany
    private List<String> dadosHistoricos;
    @OneToMany
    private List<Laje> lajes;
}
