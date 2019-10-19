package com.example.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String seat;
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(Long id, String seat, BigDecimal price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket))
            return false;
        Ticket other = (Ticket) o;
        return id != null && id.equals(other.getId());
    }
    @Override
    public int hashCode() {return 31;}

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seat='" + seat + '\'' +
                ", price=" + price +
                '}';
    }
}
