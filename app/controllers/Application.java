package controllers;

import models.Coleta;
import play.*;
import play.api.mvc.*;
import play.data.format.Formats;
import play.mvc.*;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


import play.data.Form;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import play.db.ebean.Model;

import javax.swing.text.DateFormatter;

import static play.libs.Json.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result test() throws ParseException {
        ArrayList<Coleta> coletas = new ArrayList<>();
        coletas.add(new Coleta(Long.parseLong("1"),"Campanha",new Date("07/22/2014"),"teste1"));

        coletas.add(new Coleta(Long.parseLong("2"),"Campanha",new Date(),"teste2"));
        return ok(gerenciar_amostras.render(coletas));
    }
    public static Result visualizarColeta(Long id){
        return ok();
    }
}
