package controllers;

import models.Amostra;
import models.Calha;
import models.Coleta;
import models.Laje;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.gerenciar_amostra;
import views.html.index;

/**
 * Created by franktominc on 5/3/15.
 */
public class Amostras extends Controller{

    public static Result addAmostra(){
        System.out.println(Form.form(Amostra.class).bindFromRequest());
        Amostra amostra = Form.form(Amostra.class).bindFromRequest().get();
        amostra.save();

        return ok(index.render());
    }

}
