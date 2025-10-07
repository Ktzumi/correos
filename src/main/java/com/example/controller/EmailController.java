package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String mostrarFormulario() {
        return "form";
    }
    @GetMapping("/1")
    public String mf2(){
        return "form";

    }

    @PostMapping("/enviar")
    public String enviarCorreo(@RequestParam("mensaje") String mensaje) {
        emailService.enviarCorreo(mensaje);
        return "redirect:/?enviado=true";
    }
}
