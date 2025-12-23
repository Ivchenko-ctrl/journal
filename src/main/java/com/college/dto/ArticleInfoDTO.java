package com.college.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ArticleInfoDTO {

    private String journalist;
    private String editor;
    private LocalDate publicationDate;
    private String title;
    private String category;
    private String editorComments;
    private BigDecimal rating;
    private String address;
    private String phone;

    public ArticleInfoDTO(
            String journalist,
            String editor,
            LocalDate publicationDate,
            String title,
            String category,
            String editorComments,
            BigDecimal rating,
            String address,
            String phone
    ) {
        this.journalist = journalist;
        this.editor = editor;
        this.publicationDate = publicationDate;
        this.title = title;
        this.category = category;
        this.editorComments = editorComments;
        this.rating = rating;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ArticleInfoDTO{" +
                "journalist='" + journalist + '\'' +
                ", editor='" + editor + '\'' +
                ", publicationDate=" + publicationDate +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", editorComments='" + editorComments + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}