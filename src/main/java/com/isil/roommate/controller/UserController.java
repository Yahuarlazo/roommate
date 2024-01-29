package com.isil.roommate.controller;

import com.isil.roommate.entity.User;
import com.isil.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

/**
 * Controlador para gestionar las operaciones relacionadas con los usuarios en el rol de administrador.
 */
@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Muestra la página principal del área administrativa.
     *
     * @return La vista "/" que representa la página principal del área administrativa.
     */
    @GetMapping
    public String index() {
        return "redirect:/";
    }

    @PostMapping("/users")
    public User saveUser(
            @Valid @RequestBody User user)
    {

        return userService.saveUser(user);
    }
}
