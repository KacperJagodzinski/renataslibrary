package org.jagodzinskikacper.renataslibrary.book;

import org.jagodzinskikacper.renataslibrary.author.Author;
import org.jagodzinskikacper.renataslibrary.author.AuthorService;
import org.jagodzinskikacper.renataslibrary.lend.Lend;
import org.jagodzinskikacper.renataslibrary.lend.LendService;
import org.jagodzinskikacper.renataslibrary.publisher.Publisher;
import org.jagodzinskikacper.renataslibrary.publisher.PublisherService;
import org.jagodzinskikacper.renataslibrary.user.CurrentUser;
import org.jagodzinskikacper.renataslibrary.user.User;
import org.jagodzinskikacper.renataslibrary.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final UserService userService;
    private final LendService lendService;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService, UserService userService, LendService lendService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.userService = userService;
        this.lendService = lendService;
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorService.findAll();
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherService.findAll();
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result, @AuthenticationPrincipal CurrentUser customUser, @ModelAttribute("newAuthor") String newAuthor) {
        if (result.hasErrors()) {
            return "add-book";
        }
        book.setIfActive(true);
        book.setIfLent(false);
        bookService.saveBook(book);
        User user = customUser.getUser();
        List<Book> bookList = user.getBooks();
        bookList.add(book);
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/myBooks")
    public String bookList(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        List<Book> myBooks = bookService.findBooksByUser(user);
        model.addAttribute("books",myBooks);
        return "book-list";
    }

    @GetMapping("/edit/{id}")
    public String editDog(Model model, @PathVariable Long id) {
        Book book = bookService.findBookById(id);
        model.addAttribute(book);
        return "book-edit";
    }

    @PostMapping("/edit/{id}")
    public String editedBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book-edit";
        }
        bookService.update(book);
        return "redirect:/book/myBooks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, @AuthenticationPrincipal CurrentUser customUser, Model model) {
        Book book = bookService.findBookById(id);
        book.setIfActive(false);
        bookService.update(book);
        return "redirect:/book/myBooks";
    }

    @GetMapping("/all")
    public String allBooks(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        List<Book> books = bookService.findBooksByUserIsNot(user);
        model.addAttribute("books", books);
        return "book-all";
    }

    @GetMapping("/lend/{id}")
    public String lendBook(@PathVariable Long id, @AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        Lend lend = new Lend();
        Book book = bookService.findBookById(id);
        lend.setBook(book);
        book.setIfLent(true);
        lend.setUser(user);
        LocalDateTime now = LocalDateTime.now();
        lend.setLentDate(now);
        lendService.create(lend);
        bookService.update(book);
        return "redirect:/book/all";
    }
}