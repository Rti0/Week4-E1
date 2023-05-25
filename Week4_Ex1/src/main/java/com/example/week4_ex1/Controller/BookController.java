package com.example.week4_ex1.Controller;

import com.example.week4_ex1.ApiResponse.ApiResponse;
import com.example.week4_ex1.Model.Book;
import com.example.week4_ex1.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
//All CRUD
      @GetMapping("/get")
    public ResponseEntity getAll() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.status(200).body(books);
    }

    @PostMapping("add")
    public ResponseEntity addAllBook(@Valid @RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book Added"));
    }
    @PutMapping("/update1/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book,@PathVariable Integer id ){
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body(new ApiResponse("update Books"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book is deleted"));
    }

    @GetMapping("/get-id")
    public ResponseEntity getBookById(@PathVariable Integer id){
        Book book=bookService.getBookById(id);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getBookByCategory(@PathVariable String category){
        List<Book>books=bookService.getBookByCategory(category);
        return ResponseEntity.status(200).body(category);
    }


    @GetMapping("/get-pages")
    public ResponseEntity getBooksByNumberOfPagesGreaterThan(){
        return ResponseEntity.status(200).body(bookService.getBookByNumberOfPagesGreaterThan(300));
    }


    @GetMapping("/get-author/{author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String author){
      List  <Book> books =bookService.getBooksByAuthor(author);
        return ResponseEntity.status(200).body(books);
    }



    @GetMapping("/search/{title}")
    public ResponseEntity getSearchBookByTitle(@PathVariable String title){
        Book book=bookService.getSearchBookByTitle(title);
        return ResponseEntity.status(200).body((book));
    }

}
