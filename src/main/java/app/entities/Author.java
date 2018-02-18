package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "author", uniqueConstraints = {
        @UniqueConstraint(columnNames = "PSEUDONYM")}
        )
public class Author
{
   // private Long id;
    private String firstName;
    private String secondName;
    private String pseudonym;

    private Date birthday;

    private Set<News> news = new HashSet();

    @Column(name = "FIRST_NAME")
    @JsonProperty("first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "SECOND_NAME")
    @JsonProperty("second_name")
    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Id
    @Column(name = "PSEUDONYM")
    public String getPseudonym() {
        return this.pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    @JsonBackReference
    public Set<News> getNews() {
        return this.news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }


    @Override
    public String toString()
    {
        return String.format("%s %s %s %s",  firstName, secondName, pseudonym, birthday.toString());
    }
}