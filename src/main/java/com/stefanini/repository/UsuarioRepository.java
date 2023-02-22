package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.models.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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

    public List<Usuario> findBirthdaysOfTheMonth (Month mes) {
        Query nativeQuery
                = getEntityManager().createNativeQuery(
                        "SELECT * FROM usuario WHERE MONTH(dataNascimento) = :mes ;",
                Usuario.class);
        nativeQuery.setParameter("mes", mes.getValue());

        return nativeQuery.getResultList();
    }

}
