package models;

import play.db.ebean.Model;

import java.sql.Blob;

/**
 * Created by lcad on 09/11/15.
 */
public class Picture extends Model{
    public Blob image;
}
