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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public String bookList(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        List<Book> books = bookService.findBooksByUserAndLendUserIsFalse(user);
        List<Book> lentBooks = bookService.findBooksByLendUser(user);
        List<Book> myBooksLent = bookService.findBooksByUserAndLendUserIsTrue(user);
        model.addAttribute("lentBooks", lentBooks);
        model.addAttribute("myBooksLent", myBooksLent);
        model.addAttribute("books", books);
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
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, @AuthenticationPrincipal CurrentUser customUser, Model model) {
        Book book = bookService.findBookById(id);
        book.setIfActive(false);
        bookService.update(book);
        return "redirect:/book/list";
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

        Book book = bookService.findBookById(id);
        User user = customUser.getUser();
        book.setIfLent(true);
        book.setLendUser(user);
        bookService.saveBook(book);
        return "book-list";
    }
}