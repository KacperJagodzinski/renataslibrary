package org.jagodzinskikacper.renataslibrary.book;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface BookService {
//    Book findByTitle(String title);
    void saveBook(Book book);
}
