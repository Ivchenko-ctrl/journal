package com.college;

import com.college.dto.ArticleInfoDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        String sql =
            "SELECT " +
            " j.full_name AS journalist, " +
            " e.full_name AS editor, " +
            " r.full_name AS reader, " +
            " a.publication_date, " +
            " a.title AS article_title, " +
            " c.name AS category, " +
            " a.editor_comments, " +
            " a.rating, " +
            " o.address, " +
            " o.phone " +
            "FROM articles a " +
            "JOIN journalists j ON j.id = a.journalist_id " +
            "JOIN editors e ON e.id = a.editor_id " +
            "JOIN categories c ON c.id = a.category_id " +
            "JOIN editorial_offices o ON o.id = a.editorial_office_id " +
            "JOIN article_readers ar ON ar.article_id = a.id " +
            "JOIN readers r ON r.id = ar.reader_id " +
            "ORDER BY a.publication_date, a.title";

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            @SuppressWarnings("unchecked")
            List<Object[]> rows = session.createNativeQuery(sql).getResultList();

            List<ArticleInfoDTO> result = new ArrayList<>();

            for (Object[] row : rows) {
                result.add(new ArticleInfoDTO(
                        (String) row[0],                 // journalist
                        (String) row[1],                 // editor
                        (String) row[2],                 // reader
                        ((Date) row[3]).toLocalDate(),   // publicationDate
                        (String) row[4],                 // title
                        (String) row[5],                 // category
                        (String) row[6],                 // comments
                        (BigDecimal) row[7],             // rating
                        (String) row[8],                 // address
                        (String) row[9]                  // phone
                ));
            }

            System.out.println("=== Денормалізована таблиця ===");
            for (ArticleInfoDTO dto : result) {
                System.out.println(dto);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}