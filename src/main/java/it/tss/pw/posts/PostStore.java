/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.posts;

import it.tss.pw.users.User;
import it.tss.pw.users.UserAlreadyExistException;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author posta
 */

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PostStore {

    
    
    
    @PersistenceContext(name = "pw_lombardi")
    EntityManager em;

    @PostConstruct
    public void init() {

    }

   public Collection<Post> all() {
        return em.createNamedQuery(Post.FIND_ALL)
                .getResultList();
    }

    public Post find(Long id) {
        return em.find(Post.class, id);
    }

    public Post create(Post u) {
        if (findByUsr(u.getBody()).isPresent()) {
            throw new UserAlreadyExistException(u.getBody());
        }
        return em.merge(u);
    }
    

    public Optional<Post> findByUsr(String usr) {
        return em.createNamedQuery(Post.FIND_ALL, Post.class)
                .setParameter("usr", usr)
                .getResultStream()
                .findFirst();
    }
   

    
    
    
    
    
}
