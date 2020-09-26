package org.jagodzinskikacper.renataslibrary.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String addBookForm(Model model){
        Book book = new Book();
        model.addAttribute(book);
        return "add-book";
    }
}
