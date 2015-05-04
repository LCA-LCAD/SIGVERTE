package controllers;

import models.Coleta;
import play.*;
import play.api.mvc.*;
import play.mvc.*;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


import play.data.Form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.db.ebean.Model;

import static play.libs.Json.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result test(){
        ArrayList<Coleta> coletas = new ArrayList<>();
        coletas.add(new Coleta(Long.parseLong("1"),"Campanha",new Date(),"teste1"));
        coletas.add(new Coleta(Long.parseLong("2"),"Campanha",new Date(),"teste2"));
        return ok(gerenciar_amostras.render(coletas));
    }
    public static Result visualizarColeta(Long id){
        return ok();
    }
}
