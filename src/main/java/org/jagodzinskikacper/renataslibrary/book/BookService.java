package org.jagodzinskikacper.renataslibrary.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
