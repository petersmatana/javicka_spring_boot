package cz.smonty.boty.mojedemo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, Set<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    /*
    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
    
    @Override
    public int hashCode() {
    	return this.id.hashCode() * this.title.hashCode() * this.authors.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	
    	if (o == null) {
    		return false;
    	}
    	
    	Book book = (Book) o;
    	if (this.id == book.id &&
    		this.title == book.title) {
    		
    	}
    	
    	return false;
    }
    
}
