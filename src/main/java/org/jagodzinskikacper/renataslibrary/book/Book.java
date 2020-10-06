package org.jagodzinskikacper.renataslibrary.book;

import lombok.Getter;
import lombok.Setter;
import org.jagodzinskikacper.renataslibrary.Author.Author;
import org.jagodzinskikacper.renataslibrary.publisher.Publisher;
import org.jagodzinskikacper.renataslibrary.user.User;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    private boolean ifActive;
    private boolean ifLent;
    @ManyToOne
    @JoinColumn(name="lendUser_id")
    private User lendUser;
}