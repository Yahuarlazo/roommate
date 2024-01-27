package com.isil.roommate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.isil.roommate.entity.User;
import com.isil.roommate.repository.UserRepository;

/**
 * Implementación personalizada de UserDetailsService para la autenticación de usuarios.
 *
 * <p>
 * Esta clase implementa la interfaz UserDetailsService de Spring Security, proporcionando
 * una implementación personalizada del método loadUserByUsername. Este método es
 * utilizado durante el proceso de autenticación para cargar los detalles del usuario
 * basados en su nombre de usuario.
 * </p>
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    /**
     * Constructor de la clase UserDetailsServiceImpl.
     *
     * @param userRepo Repositorio de usuarios para interactuar con la base de datos.
     */
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    /**
     * Carga los detalles del usuario basados en el nombre de usuario proporcionado.
     *
     * @param username Nombre de usuario del usuario a autenticar.
     * @return UserDetails que representa los detalles del usuario.
     * @throws UsernameNotFoundException Si no se encuentra el usuario con el nombre de usuario proporcionado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("El usuario '" + username + "' no existe");
    }
}
