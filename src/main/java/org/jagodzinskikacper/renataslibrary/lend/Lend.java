package org.jagodzinskikacper.renataslibrary.lend;

import lombok.Getter;
import lombok.Setter;
import org.jagodzinskikacper.renataslibrary.book.Book;
import org.jagodzinskikacper.renataslibrary.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Lend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;
    private LocalDateTime lentDate;
    private LocalDateTime returnDate;




}
