package models;

import models.utils.Point;
import play.db.ebean.Model;

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
    private Point x;
    private Point y;
    @OneToMany
    private List<File> imagens;
    @OneToMany
    private List<String> comentarios;
}
