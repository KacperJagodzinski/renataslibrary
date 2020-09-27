package org.jagodzinskikacper.renataslibrary.book;

import lombok.Getter;
import lombok.Setter;
import org.jagodzinskikacper.renataslibrary.Author.Author;
import org.jagodzinskikacper.renataslibrary.publisher.Publisher;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    private Category category;
    private int pages;


}
