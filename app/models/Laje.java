package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.File;
import java.util.List;

/**
 * Created by ftominc on 29/04/15.
 */
@Entity
public class Laje extends Model{
    @Id
    private Long id;
    @OneToMany
    private List<String> descricao;
    @OneToMany
    private List<File> imagens;
}
