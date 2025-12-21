package com.college;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "articles")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    private BigDecimal rating;

    @Column(name = "editor_comments")
    private String editorComments;

    @ManyToOne
    @JoinColumn(name = "journalist_id")
    private JournalistEntity journalist;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private EditorEntity editor;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "editorial_office_id")
    private EditorialOfficeEntity editorialOffice;
}