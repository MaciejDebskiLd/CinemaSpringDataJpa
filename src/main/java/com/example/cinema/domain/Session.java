package com.example.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime startTime;

    public Session() {
    }

    public Session(Long id, LocalDateTime startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof Session))
            return false;
        Session other = (Session) o;
        return id != null && id.equals(other.getId());
    }
    @Override
    public int hashCode() {return 31;}

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startTime=" + startTime +
                '}';
    }
}
