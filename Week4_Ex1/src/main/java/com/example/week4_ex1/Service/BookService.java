package com.example.week4_ex1.Service;

import com.example.week4_ex1.ApiException.ApiException;
import com.example.week4_ex1.Model.Book;
import com.example.week4_ex1.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;


    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void updateBook(int id,Book book){
        Book old = bookRepository.getBookById(id);
        old.setAuthor(book.getAuthor());
        old.setIsbn(book.getIsbn());
        old.setCategory(book.getCategory());
        old.setNumberOfPages(book.getNumberOfPages());
        old.setTitle(book.getTitle());
        bookRepository.save(old);
    }


    public void deleteBook(int id){
        Book old=bookRepository.findBookById(id);
        if (old==null){
            throw new ApiException("Wrong Deleted");
        }

        bookRepository.delete(old);

    }

    public Book getBookById(Integer id){
        Book book= bookRepository.findBookById(id);
        if (book== null){
            throw new ApiException("Not Found");
        }
        return book;
    }


    public  List<Book> getBookByCategory(String category){
        List<Book>books=bookRepository.getBookByCategory(category);
        if (books==null){
            throw new ApiException("Wrong Category");
        }
        return books;
    }
    public List<Book> getBookByNumberOfPagesGreaterThan (Integer pages) {
        List<Book> books = bookRepository.getBooksByNumberOfPagesGreaterThan(pages);
        if (books == null) {
            throw new ApiException("Not Found");

        }
        return books;
    }
    public List<Book> getBooksByAuthor(String author){
        List<Book>books= bookRepository.getBooksByAuthor(author);
        if (books==null){
            throw new ApiException("Not Found");
        }
        return books;
    }
    public Book getSearchBookByTitle(String title){
        Book  book=bookRepository.getSearchBookByTitle(title);
        if (book==null){
            throw new ApiException("Not Found");
        }
        return book;
    }
}
