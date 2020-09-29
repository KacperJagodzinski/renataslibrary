package org.jagodzinskikacper.renataslibrary.book;

import org.jagodzinskikacper.renataslibrary.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllById(Long id);
    List<Book> findBooksByUser(User user);

}
