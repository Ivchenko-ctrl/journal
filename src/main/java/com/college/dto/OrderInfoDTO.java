package com.college.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderInfoDTO {

    private final String magazin;
    private final String postachalnik;
    private final String logistychnaKompaniya;
    private final LocalDate dataZamovlennya;
    private final String partiyaTovaru;
    private final String kategoriaTovaruOsnovna;
    private final BigDecimal optovaZnyzhka;
    private final String adresSkladu;
    private final String telefonSkladu;
    private final String umovyDostavky;

    public OrderInfoDTO(
            String magazin,
            String postachalnik,
            String logistychnaKompaniya,
            LocalDate dataZamovlennya,
            String partiyaTovaru,
            String kategoriaTovaruOsnovna,
            BigDecimal optovaZnyzhka,
            String adresSkladu,
            String telefonSkladu,
            String umovyDostavky
    ) {
        this.magazin = magazin;
        this.postachalnik = postachalnik;
        this.logistychnaKompaniya = logistychnaKompaniya;
        this.dataZamovlennya = dataZamovlennya;
        this.partiyaTovaru = partiyaTovaru;
        this.kategoriaTovaruOsnovna = kategoriaTovaruOsnovna;
        this.optovaZnyzhka = optovaZnyzhka;
        this.adresSkladu = adresSkladu;
        this.telefonSkladu = telefonSkladu;
        this.umovyDostavky = umovyDostavky;
    }

    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "magazin='" + magazin + '\'' +
                ", postachalnik='" + postachalnik + '\'' +
                ", logistychnaKompaniya='" + logistychnaKompaniya + '\'' +
                ", dataZamovlennya=" + dataZamovlennya +
                ", partiyaTovaru='" + partiyaTovaru + '\'' +
                ", kategoriaTovaruOsnovna='" + kategoriaTovaruOsnovna + '\'' +
                ", optovaZnyzhka=" + optovaZnyzhka +
                ", adresSkladu='" + adresSkladu + '\'' +
                ", telefonSkladu='" + telefonSkladu + '\'' +
                ", umovyDostavky='" + umovyDostavky + '\'' +
                '}';
    }
}