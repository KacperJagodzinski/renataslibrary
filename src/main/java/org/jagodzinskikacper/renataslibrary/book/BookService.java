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
    Book findBookById(Long id){
        return bookRepository.findBookById(id);
    }
    void update(Book book){
        bookRepository.save(book);
    }

//    void deleteOne(Long id){bookRepository.deleteById(id);}

    List<Book> findBooksByUserIsNot(User user){
        return bookRepository.findBooksByUserIsNot(user);
    }

    List<Book> findBooksByLendUser(User user){return bookRepository.findBooksByLendUser(user);}

    List<Book> findBooksByUserAndLendUserIsFalse(User user){ return bookRepository.findBooksByUserAndLendUserIsNull(user);}

    List<Book> findBooksByUserAndLendUserIsTrue(User user){ return bookRepository.findBooksByUserAndLendUserIsNotNull(user);}


}