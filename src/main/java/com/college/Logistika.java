package com.college;

import javax.persistence.*;
@Entity
@Table(name = "logistika")
public class Logistika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logistika")
    private Long id;

    @Column(name = "nazva_kompanii", length = 100, nullable = false)
    private String nazvaKompanii;

    @Column(name = "adres_sklada", length = 150, nullable = false)
    private String adresSklada;

    @Column(name = "telefon_sklada", length = 15, nullable = false)
    private String telefonSklada;

    public Long getId() { return id; }
    public String getNazvaKompanii() { return nazvaKompanii; }
    public void setNazvaKompanii(String nazvaKompanii) { this.nazvaKompanii = nazvaKompanii; }
    public String getAdresSklada() { return adresSklada; }
    public void setAdresSklada(String adresSklada) { this.adresSklada = adresSklada; }
    public String getTelefonSklada() { return telefonSklada; }
    public void setTelefonSklada(String telefonSklada) { this.telefonSklada = telefonSklada; }
}