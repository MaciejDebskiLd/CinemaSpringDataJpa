package com.example.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String filePath;

    public Poster() {
    }

    public Poster(Long id, String filePath) {
        this.id = id;
        this.filePath = filePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poster))
            return false;
        Poster other = (Poster) o;
        return id != null && id.equals(other.getId());
    }
    @Override
    public int hashCode() {return 31;}

    @Override
    public String toString() {
        return "Poster{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
