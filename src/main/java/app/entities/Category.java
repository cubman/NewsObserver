package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category")
public class Category implements Serializable
{
    private Long id;
    private String title;

    private Set<News> news = new HashSet();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @JsonBackReference
    public Set<News> getNews() {
        return this.news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    @Override
    public int hashCode(){
        return id.hashCode() + title.hashCode();
    }

    @Override
    public boolean equals(Object o){
        Category c = (Category)o;
        return id == c.id && title == c.title;
    }

    @Override
    public String toString()
    {
        return id + " " + title;
    }
}
