package com.college;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "postachalnik")
public class Postachalnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postachalnika")
    private Long id;

    @Column(name = "nazva_postachalnika", length = 100, nullable = false)
    private String nazvaPostachalnika;

    @Column(name = "kategoria_tovary", length = 50, nullable = false)
    private String kategoriaTovary;

    @Column(name = "opt_skidka", precision = 5, scale = 2, nullable = false)
    private BigDecimal optSkidka;

    public Long getId() { return id; }
    public String getNazvaPostachalnika() { return nazvaPostachalnika; }
    public void setNazvaPostachalnika(String nazvaPostachalnika) { this.nazvaPostachalnika = nazvaPostachalnika; }
    public String getKategoriaTovary() { return kategoriaTovary; }
    public void setKategoriaTovary(String kategoriaTovary) { this.kategoriaTovary = kategoriaTovary; }
    public BigDecimal getOptSkidka() { return optSkidka; }
    public void setOptSkidka(BigDecimal optSkidka) { this.optSkidka = optSkidka; }
}