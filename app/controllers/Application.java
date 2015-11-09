package controllers;

import com.avaje.ebean.Ebean;
import models.Calha;
import models.Coleta;
import play.Play;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.*;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application extends Controller {

    public static Result upload(){

        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if(picture !=null){
            String calhaId = form().bindFromRequest().get("calhaId");
            String imagem = calhaId + ".png";
            File file = picture.getFile();

            String diretorioDeImagens = Play.application().configuration().getString("diretorioDeImagens");
            file.renameTo(new File(diretorioDeImagens,imagem));
            return ok(views.html.upload.render("Arquivo  \"" + imagem + "\" foi carregado com sucesso!"));
        }else{
            flash("error", "Erro ao fazer upload");
            return redirect(routes.Application.index());
        }
    }

    public static Result formImage() {
        List<Calha> calhas = Ebean.createQuery(Calha.class).findList();
        return ok(uploadCalhaPic.render(calhas));
    }

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
