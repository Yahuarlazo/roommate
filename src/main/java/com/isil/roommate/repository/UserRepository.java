package com.isil.roommate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.isil.roommate.entity.User;

/**
 * Repositorio para interactuar con la entidad de usuario en la base de datos.
 *
 * <p>
 * Esta interfaz extiende la interfaz CrudRepository de Spring Data, proporcionando
 * métodos estándar para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * en la entidad User.
 * </p>
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Busca y devuelve un usuario según su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario a buscar.
     * @return El usuario correspondiente al nombre de usuario proporcionado.
     */
    User findByUsername(String username);
}
