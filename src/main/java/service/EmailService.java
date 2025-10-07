package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String mensaje) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("sergio.rivera.velarde@gmail.com"); // destino fijo o configurable
        mail.setFrom("acardenasriv2@gmail.com");
        mail.setSubject("Nuevo mensaje desde el formulario web");
        mail.setText("El usuario escribió: " + mensaje);
        mailSender.send(mail);

    }
}
