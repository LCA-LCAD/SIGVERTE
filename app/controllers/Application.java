package controllers;

import com.avaje.ebean.Ebean;
import models.Calha;
import models.Coleta;
import play.Play;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import static play.data.Form.form;


public class Application extends Controller {

    public static Result upload() {

        MultipartFormData body = request().body().asMultipartFormData();
        FilePart picture = body.getFile("picture");
        String extensaoPadraoDeImagens = Play.application().configuration().getString("extensaoPadraoDeImagens");
        if (picture != null) {

            String filmeId = form().bindFromRequest().get("calhaId");
            String imagem = filmeId + extensaoPadraoDeImagens;
            String contentType = picture.getContentType();
            File file = picture.getFile();

            String diretorioDeImagens = Play.application().configuration().getString("diretorioDeImagens");
            String contentTypePadraoDeImagens = Play.application().configuration().getString("contentTypePadraoDeImagens");

            if (contentType.equals(contentTypePadraoDeImagens)) {

                file.renameTo(new File(diretorioDeImagens,imagem));
                return ok(views.html.upload.render("Arquivo  \"" + imagem + "\" do tipo [" + contentType + "] foi carregado com sucesso !"));

            } else {

                return ok(views.html.upload.render("Imagens apenas no formato \"" + contentTypePadraoDeImagens + "\" serão aceitas!"));

            }

        } else {
            flash("error","Erro ao fazer upload");
            return redirect(routes.Application.index());
        }
    }

    public static Result imagem(String id) throws IOException {

        String diretorioDeImagens = Play.application().configuration().getString("diretorioDeImagens");

        File imagem = new File(diretorioDeImagens,id + ".png");

        return ok(new FileInputStream(imagem));

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
