package UD.BaseDeDatosAvanzada.ProyectoFinal.Controllers.TemplatesCTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewRegistroCTO {
    @GetMapping({"/registro_agencia"})
    public ModelAndView registroAgencias() {
        return new ModelAndView("Registro_agencias");
    }
    @GetMapping({"/registro_huespedes"})
    public ModelAndView registroHuespedes() {
        return new ModelAndView("RegistroHuespedes");
    }
    @GetMapping({"/reserva_nueva"})
    public ModelAndView registroNueva() {
        return new ModelAndView("ReservaNueva");
    }
    @GetMapping({"/seleccioandor_de_logeo"})
    public ModelAndView seleccionLogeo() {
        return new ModelAndView("Seleccionador_de_logeo");
    }
    @GetMapping({"/ventana_de_logeo"})
    public ModelAndView registro() {
        return new ModelAndView("VentanaLogeo");
    }
    @GetMapping({"/registro_responsable"})
    public ModelAndView registroResponsable() {
        return new ModelAndView("VistaResponsable");
    }
}
