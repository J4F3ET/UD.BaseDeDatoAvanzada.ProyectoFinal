package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginCTO {
    @GetMapping({"/login"})
    public ModelAndView index() {
        return new ModelAndView("login");
    }
}
