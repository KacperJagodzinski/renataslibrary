package org.jagodzinskikacper.renataslibrary.book;

import org.jagodzinskikacper.renataslibrary.Author.Author;
import org.jagodzinskikacper.renataslibrary.Author.AuthorService;
import org.jagodzinskikacper.renataslibrary.publisher.Publisher;
import org.jagodzinskikacper.renataslibrary.publisher.PublisherService;
import org.jagodzinskikacper.renataslibrary.user.CurrentUser;
import org.jagodzinskikacper.renataslibrary.user.User;
import org.jagodzinskikacper.renataslibrary.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final UserService userService;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService, UserService userService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        Book book = new Book();
        List<Author> authors = authorService.findAll();
        List<Publisher> publishers = publisherService.findAll();
        model.addAttribute("authors",authors);
        model.addAttribute("book",book);
        model.addAttribute("publishers",publishers);
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result,@AuthenticationPrincipal CurrentUser customUser){
        if(result.hasErrors()){
            return"add-book";
        }
        bookService.saveBook(book);
        User user = customUser.getUser();
        List<Book> bookList = user.getBooks();
        bookList.add(book);
        userService.saveUser(user);
        return "redirect:/";
    }
}
