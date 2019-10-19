package com.example.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private LocalDateTime startTime;

    public Marathon() {
    }
    public Marathon(Long id, String name, LocalDateTime startTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marathon))
            return false;
        Marathon other = (Marathon) o;
        return id != null && id.equals(other.getId());
    }
    @Override
    public int hashCode() {return 31;}

    @Override
    public String toString() {
        return "Marathon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
