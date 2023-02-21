package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.models.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<Usuario, Long> {

    public Usuario findByLogin (String login){
        TypedQuery<Usuario> jpqlQuery = getEntityManager()
                .createQuery("SELECT u FROM Usuario u WHERE u.login =:login", Usuario.class);
        jpqlQuery.setParameter("login", login);

        Usuario usuario = null;
        try{
            usuario = jpqlQuery.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
        return usuario;
    }
}
