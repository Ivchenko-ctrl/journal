package com.college;

import javax.persistence.*;
@Entity
@Table(name = "magazin")
public class Magazin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_magazin")
    private Long id;

    @Column(name = "nazva_magazin", length = 100, nullable = false)
    private String nazvaMagazin;

    public Long getId() { return id; }
    public String getNazvaMagazin() { return nazvaMagazin; }
    public void setNazvaMagazin(String nazvaMagazin) { this.nazvaMagazin = nazvaMagazin; }
}