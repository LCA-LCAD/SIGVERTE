package controllers;

import com.avaje.ebean.Ebean;
import models.Calha;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import play.data.Form;
import java.util.List;


/**
 * Created by lcad on 23/10/15.
 */
public class Calhas extends Controller{

    public static Result CadastrarCalha() {
        Form<Calha> formCalha = Form.form(Calha.class);
        return ok(gerenciar_calha.render(formCalha));
    }

    public static Result novaCalha() {
        Form<Calha> formCalha = Form.form(Calha.class).bindFromRequest();
        if (formCalha.hasErrors()) {
            return badRequest(gerenciar_calha.render(formCalha));
        }
        Calha calha = formCalha.get();
        calha.save();
        List<Calha> calhas = Ebean.createQuery(Calha.class).findList();
        return ok(uploadCalhaPic.render(calhas));
    }

    /*public static Result index(){
        List<Calha> calhas = Ebean.createQuery(Calha.class).findList();
        return ok(uploadCalhaPic.render(calhas));
    }*/
}
