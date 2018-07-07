package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String FirstName;
    private String LastName;
    
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
    
    public Author(){
        
    }
    
    public Author(String firstName, String lastName){
       this.FirstName = firstName;
       this.LastName = lastName;
    }
    
    public Author(String firstName, String lastName, Set<Book> books){
       this.FirstName = firstName;
       this.LastName = lastName;
       this.books = books;
    }
    
    public String getFirstName() {
        return FirstName;
    }
    
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    
    public String getLastName() {
        return LastName;
    }
    
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Author author =(Author) obj;
        return id != null ? id.equals(author.id) : author.id == null;
    }
    
    @Override
    public String toString() {
            return "Author{" +
            "id=" +id+
            ",FirstName ="+FirstName +
            ",LastName = "+LastName +
            ", books=" + books + "}";
    }
}
