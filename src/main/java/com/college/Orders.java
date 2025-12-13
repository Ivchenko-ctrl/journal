package com.college;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @Column(name = "data_zamovlenya", nullable = false)
    private LocalDate dataZamovlenya;

    @Column(name = "umovi_dostavki", columnDefinition = "text")
    private String umoviDostavki;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_postachalnik", referencedColumnName = "id_postachalnika")
    private Postachalnik postachalnik;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_logistika", referencedColumnName = "id_logistika")
    private Logistika logistika;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_magazin", referencedColumnName = "id_magazin")
    private Magazin magazin;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partiya> partiyi = new ArrayList<>();

    public Long getId() { return id; }
    public LocalDate getDataZamovlenya() { return dataZamovlenya; }
    public void setDataZamovlenya(LocalDate dataZamovlenya) { this.dataZamovlenya = dataZamovlenya; }
    public String getUmoviDostavki() { return umoviDostavki; }
    public void setUmoviDostavki(String umoviDostavki) { this.umoviDostavki = umoviDostavki; }
    public Postachalnik getPostachalnik() { return postachalnik; }
    public void setPostachalnik(Postachalnik postachalnik) { this.postachalnik = postachalnik; }
    public Logistika getLogistika() { return logistika; }
    public void setLogistika(Logistika logistika) { this.logistika = logistika; }
    public Magazin getMagazin() { return magazin; }
    public void setMagazin(Magazin magazin) { this.magazin = magazin; }
    public List<Partiya> getPartiyi() { return partiyi; }
}