package com.college.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ArticleInfoDTO {
    public final String journalist;
    public final String editor;
    public final String reader;
    public final LocalDate publicationDate;
    public final String articleTitle;
    public final String category;
    public final String editorComments;
    public final BigDecimal rating;
    public final String editorialAddress;
    public final String editorialPhone;

    public ArticleInfoDTO(
            String journalist,
            String editor,
            String reader,
            LocalDate publicationDate,
            String articleTitle,
            String category,
            String editorComments,
            BigDecimal rating,
            String editorialAddress,
            String editorialPhone
    ) {
        this.journalist = journalist;
        this.editor = editor;
        this.reader = reader;
        this.publicationDate = publicationDate;
        this.articleTitle = articleTitle;
        this.category = category;
        this.editorComments = editorComments;
        this.rating = rating;
        this.editorialAddress = editorialAddress;
        this.editorialPhone = editorialPhone;
    }

    @Override
    public String toString() {
        return "ArticleInfoDTO{" +
                "journalist='" + journalist + '\'' +
                ", editor='" + editor + '\'' +
                ", reader='" + reader + '\'' +
                ", publicationDate=" + publicationDate +
                ", articleTitle='" + articleTitle + '\'' +
                ", category='" + category + '\'' +
                ", editorComments='" + editorComments + '\'' +
                ", rating=" + rating +
                ", editorialAddress='" + editorialAddress + '\'' +
                ", editorialPhone='" + editorialPhone + '\'' +
                '}';
    }
}