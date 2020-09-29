package org.jagodzinskikacper.renataslibrary.book;

import org.jagodzinskikacper.renataslibrary.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

//    Book findByTitle(String title);
    void saveBook(Book book){
        bookRepository.save(book);
    };

    List<Book> findBooksByUser(User user){
        return bookRepository.findBooksByUser(user);
    }


}
