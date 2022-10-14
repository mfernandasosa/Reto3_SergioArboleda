
package com.reto3.usa;

import javax.swing.Spring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class controladorInicial {
    //@Value("${index.mensaje}");
    //Spring dato;
    @GetMapping("/")//Construir la URL
    public String saludar(){
        //String mensaje = "Bienvenido";
        //modelo.addAtribute("clave1", mensaje);
        //modelo.addAtribute("clave2", dato);
        //log.info("Iniciando la estructura MVC");
        return "Ruta Nueva";
    }
}
