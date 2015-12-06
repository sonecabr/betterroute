package com.soneca.wmtest.persistence.dao;

import com.soneca.wmtest.core.entity.IEntity;
import com.soneca.wmtest.core.entity.Route;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andre
 * @since 06/12/2015 13:29
 */
@Model
@Transactional(Transactional.TxType.SUPPORTS)
public class RouteDAO {

    @PersistenceContext(unitName = "wmtest", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @PostConstruct
    private void init(){
        if(em == null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("wmtest");
            em = factory.createEntityManager();
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Route save(Route entity){

        if(entity.getId() == null){
            em.persist(entity);
        } else {
            em.merge(entity);
        }

        return entity;
    }

    public Route get(Long id) {
        Query query = em.createQuery("select r from Route r where r.id = :p");
        query.setParameter("p", id);
        return (Route) query.getSingleResult();
    }

    public List<Route> findRoutes(String parentName){
        Query query = em.createQuery("select r from Route r where r.parentName = :p");
        query.setParameter("p", parentName);
        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<>();
        }

    }

}
