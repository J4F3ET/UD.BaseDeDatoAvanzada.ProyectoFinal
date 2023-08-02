package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.TemplatesCTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutCTO {
    @GetMapping({"/about"})
    public ModelAndView about() {
        return new ModelAndView("about");
    }

}
