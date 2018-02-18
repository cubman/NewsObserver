package app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "news")
public class News
{
    private Long id;
    private String title;
    private String shortDescription;
    private String fullDescription;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timePublic;

    Set<Author> authors = new HashSet();
    Set<Category> categories = new HashSet();

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

    @Column(name = "SHORT_DESCRIPTION")
    @JsonProperty("short_description")
    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Column(name = "FULL_DESCRIPTION")
    @JsonProperty("full_description")
    public String getFullDescription() {
        return this.fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_PUBLIC")
    @JsonProperty("time_public")
    public Date getTimePublic() {
        return this.timePublic;
    }

    public void setTimePublic(Date timePublic) {
        this.timePublic = timePublic;
    }

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY )
    @JoinTable(
            name = "AUTHOR_NEWS",
            joinColumns = {@JoinColumn(name = "news_id") },
            inverseJoinColumns = {@JoinColumn(name = "author_pseudonym")}
    )
    @JsonManagedReference
    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY )
    @JoinTable(
            name = "CATEGORY_NEWS",
            joinColumns = {@JoinColumn(name = "news_id") },
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    @JsonManagedReference
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString()
    {
        return String.format("%d %s %s %s %s", id, title, shortDescription, fullDescription, timePublic.toString());
    }
}
