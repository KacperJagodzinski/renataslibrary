package org.jagodzinskikacper.renataslibrary.book;

import lombok.Getter;
import lombok.Setter;
import org.jagodzinskikacper.renataslibrary.Author.Author;
import org.jagodzinskikacper.renataslibrary.publisher.Publisher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    private Author author;
//    private Publisher publisher;
    private Category category;
    private int pages;


}
