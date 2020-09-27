package org.jagodzinskikacper.renataslibrary.Author;

import lombok.Getter;
import lombok.Setter;
import org.jagodzinskikacper.renataslibrary.book.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
}
