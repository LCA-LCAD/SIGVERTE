package controllers;

import models.Calha;
import models.Laje;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import views.html.gerenciar_calha;

/**
 * Created by lcad on 23/10/15.
 */
public class Lajes extends Controller{
    public static Result novaLaje() {
        Form<Laje> formLaje = Form.form(Laje.class).bindFromRequest();
        if (formLaje.hasErrors()) {
            return badRequest(gerenciar_laje.render(formLaje));
        }
        Laje laje = formLaje.get();
        laje.save();
        return redirect(routes.Application.index());
    }

    public static Result CadastrarLaje() {
        Form<Laje> formLaje = Form.form(Laje.class);
        return ok(gerenciar_laje.render(formLaje));
    }

    /*public static Result index(){
        List</Laje> lajes = Ebean.createQuery(Laje.class).findList();
        return ok(listaslajes.render(lajes));
    }*/

}
