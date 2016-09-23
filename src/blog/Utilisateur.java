/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    
    
    //Page
    @OneToMany(mappedBy = "utilisateur")
    private List<Page> pages= new ArrayList<>();
    
    
    //Article
     @OneToMany(mappedBy = "utilisateur")
    private List<Article> articles= new ArrayList<>();
    
    //Message
     @OneToMany(mappedBy = "utilisateur")
    private List<Message> messages= new ArrayList<>();
     
    
     //Commentaire
     @OneToMany(mappedBy = "utilisateur")
    private List<Commentaire> commentaires= new ArrayList<>();
     
     
     
     
     //utilisateur massage
     @ManyToMany
     @JoinTable(name = "utilisateur_message1")
     private List<Message> messages1 =new ArrayList<>();
     
     
     
     //utilisateur num
    @OneToOne
    @JoinColumn(name = "utilisateur_secu")
    private NumSecu numSecu;
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blog.Utilisateur[ id=" + id + " ]";
    }
    
}
