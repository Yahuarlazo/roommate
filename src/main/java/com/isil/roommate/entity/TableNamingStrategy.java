package com.isil.roommate.entity;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * Estrategia de nombramiento de tablas personalizada para Hibernate.
 * 
 * <p>
 * Esta clase extiende la implementación estándar de Hibernate para estrategias de
 * nombramiento físico de tablas. Modifica los nombres de las tablas agregando el
 * prefijo "tb_" y convirtiendo los nombres a minúsculas.
 * </p>
 */
public class TableNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    /**
     * Convierte el nombre físico de la tabla, agregando el prefijo "tb_" y
     * convirtiendo los caracteres a minúsculas.
     *
     * @param name    El nombre original de la tabla.
     * @param context El entorno JDBC.
     * @return El nombre físico de la tabla modificado.
     */
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier("tb_" + name.getText().toLowerCase(), name.isQuoted());
    }
}
