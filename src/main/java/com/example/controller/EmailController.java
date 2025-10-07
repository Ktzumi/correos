package com.example.demo.controller;

import com.example.demo.service.EmailService;
//import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;
   // private MailService mailService;

    @GetMapping("/")
    public String mostrarFormulario() {
        return "form";
    }
    

    @GetMapping("/form2")
    public String mostrarConfiguracion() {
        return "form2"; // tu form2.html
    }

    @PostMapping("/enviar")
    public String enviarCorreo(@RequestParam("mensaje") String mensaje) {

        
        emailService.enviarCorreo(mensaje);
        //mailService.sendEmail(mensaje);
        
        // Luego rediriges a la segunda página
        return "redirect:/form2";
        //return "redirect:/?enviado=true";
    }

    @PostMapping("/finalizar-configuracion")
    public String finalizarConfiguracion() {
        return "redirect:/configurationend";
    }

    @GetMapping("/configurationend")
    public String mostrarFinal() {
        return "configurationend";
    }
}
