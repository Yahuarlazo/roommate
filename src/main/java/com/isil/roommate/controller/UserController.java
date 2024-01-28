package com.isil.roommate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para gestionar las operaciones relacionadas con los usuarios en el rol de administrador.
 */
@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class UserController {

    /**
     * Muestra la página principal del área administrativa.
     *
     * @return La vista "/" que representa la página principal del área administrativa.
     */
    @GetMapping
    public String index() {
        return "redirect:/";
    }

}
