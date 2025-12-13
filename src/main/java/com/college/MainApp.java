package com.college;

import com.college.dto.OrderInfoDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for the application.
 * - Initializes Hibernate
 * - Runs a denormalized query for orders and prints results
 */
public class MainApp {

    public static void main(String[] args) {
        // 1) Build SessionFactory using hibernate.cfg.xml
        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

            // 2) Run query and print results
            List<OrderInfoDTO> rows = fetchDenormalizedOrderInfo(sessionFactory);

            System.out.println("==============================================");
            System.out.println("DENORMALIZED ORDER INFO (rows): " + rows.size());
            System.out.println("==============================================");

            for (OrderInfoDTO row : rows) {
                System.out.println(row);
            }

            System.out.println("==============================================");
            System.out.println("DONE");
            System.out.println("==============================================");

        } catch (Exception e) {
            System.err.println("ERROR while running application:");
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    /**
     * Denormalized query (your table requirements):
     * - magazin
     * - postachalnik
     * - logistychna kompaniya
     * - order date
     * - aggregated "partiya tovary" string (product:qty; ...)
     * - category
     * - wholesale discount
     * - warehouse address & phone
     * - delivery conditions
     */
    private static List<OrderInfoDTO> fetchDenormalizedOrderInfo(SessionFactory sessionFactory) {
        String sql =
                "SELECT " +
                "  m.nazva_magazin AS magazin, " +
                "  p.nazva_postachalnika AS postachalnik, " +
                "  l.nazva_kompanii AS logistychna_kompaniya, " +
                "  o.data_zamovlenya AS data_zamovlennya, " +
                "  string_agg(pr.nazva_tovaru || ':' || pr.kolichestvo, '; ' ORDER BY pr.id_partii) AS partiya_tovaru, " +
                "  p.kategoria_tovary AS kategoria_tovaru_osnovna, " +
                "  p.opt_skidka AS optova_znyzhka, " +
                "  l.adres_sklada AS adres_skladu, " +
                "  l.telefon_sklada AS telefon_skladu, " +
                "  o.umovi_dostavki AS umovy_dostavky " +
                "FROM orders o " +
                "JOIN magazin m ON m.id_magazin = o.id_magazin " +
                "JOIN postachalnik p ON p.id_postachalnika = o.id_postachalnik " +
                "JOIN logistika l ON l.id_logistika = o.id_logistika " +
                "JOIN partiya pr ON pr.id_order = o.id_order " +
                "GROUP BY " +
                "  m.nazva_magazin, " +
                "  p.nazva_postachalnika, " +
                "  l.nazva_kompanii, " +
                "  o.data_zamovlenya, " +
                "  p.kategoria_tovary, " +
                "  p.opt_skidka, " +
                "  l.adres_sklada, " +
                "  l.telefon_sklada, " +
                "  o.umovi_dostavki " +
                "ORDER BY o.data_zamovlenya, m.nazva_magazin";

        List<OrderInfoDTO> result = new ArrayList<>();

        try (Session session = sessionFactory.openSession()) {
            @SuppressWarnings("unchecked")
            List<Object[]> rows = session.createNativeQuery(sql).getResultList();

            for (Object[] r : rows) {
                String magazin = (String) r[0];
                String postachalnik = (String) r[1];
                String logistychnaKompaniya = (String) r[2];

                // PostgreSQL date comes as java.sql.Date
                LocalDate dataZamovlennya = null;
                if (r[3] instanceof Date) {
                    dataZamovlennya = ((Date) r[3]).toLocalDate();
                } else if (r[3] instanceof java.time.LocalDate) {
                    dataZamovlennya = (LocalDate) r[3];
                }

                String partiyaTovaru = (String) r[4];
                String kategoria = (String) r[5];

                BigDecimal optZnyzhka = null;
                if (r[6] instanceof BigDecimal) {
                    optZnyzhka = (BigDecimal) r[6];
                } else if (r[6] != null) {
                    optZnyzhka = new BigDecimal(r[6].toString());
                }

                String adres = (String) r[7];
                String telefon = (String) r[8];
                String umovy = (String) r[9];

                result.add(new OrderInfoDTO(
                        magazin,
                        postachalnik,
                        logistychnaKompaniya,
                        dataZamovlennya,
                        partiyaTovaru,
                        kategoria,
                        optZnyzhka,
                        adres,
                        telefon,
                        umovy
                ));
            }
        }

        return result;
    }
}