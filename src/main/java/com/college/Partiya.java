package com.college;

import javax.persistence.*;
@Entity
@Table(name = "partiya")
public class Partiya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partii")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    private Orders order;

    @Column(name = "nazva_tovaru", length = 100, nullable = false)
    private String nazvaTovaru;

    @Column(name = "kolichestvo", nullable = false)
    private Integer kolichestvo;

    public Long getId() { return id; }
    public Orders getOrder() { return order; }
    public void setOrder(Orders order) { this.order = order; }
    public String getNazvaTovaru() { return nazvaTovaru; }
    public void setNazvaTovaru(String nazvaTovaru) { this.nazvaTovaru = nazvaTovaru; }
    public Integer getKolichestvo() { return kolichestvo; }
    public void setKolichestvo(Integer kolichestvo) { this.kolichestvo = kolichestvo; }
}