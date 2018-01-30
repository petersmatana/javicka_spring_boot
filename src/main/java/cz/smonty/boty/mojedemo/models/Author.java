package cz.smonty.boty.mojedemo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books  = new HashSet<>();

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    // opravdu?
    /*
    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public Set<Book> getBooks() {
        return books;
    }

	public void setBooks(Set<Book> books) {
        this.books = books;
    }
	
	@Override
	public int hashCode() {
		return this.id.hashCode() * this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null) {
			return false;
		}
		
		// otazka je, jestli je toto ok:
		// author.books == this.books
		
		Author author = (Author) o;
		if (author.id == this.id &&
			author.name == this.name &&
			author.books == this.books) {
			return true;
		}
		
		return false;
	}
}
