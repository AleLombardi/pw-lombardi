/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.posts;

import it.tss.pw.AbstractEntity;
import it.tss.pw.users.User;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author posta
 */
@NamedQueries({
@NamedQuery(name = Post.FIND_ALL, query = "select e from Post e order by e.body")})


@Entity
@Table(name = "post")
public class Post extends AbstractEntity {
    public static final String FIND_ALL = "Post.findAll";

   
    
    
    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;
    
    @NotEmpty
    @Column(name = "body", nullable = false)
    private String body;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
    
    @Column(name = "end_date")
    private LocalDate endDate;

    public Post() {
    }
    
    

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
        //this.endDate = endDate;
    }
    
    
    
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Post{" + "title=" + title + ", body=" + body + ", owner=" + owner + ", endDate=" + endDate + '}';
    }
    
    
    
    
    
    
    
}

    