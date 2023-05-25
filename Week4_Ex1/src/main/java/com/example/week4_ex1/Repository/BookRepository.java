package com.example.week4_ex1.Repository;

import com.example.week4_ex1.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

        Book findBookById(int id);
        Book getBookById(Integer id);
        List<Book> getBookByCategory(String category);
        List<Book> getBooksByAuthor(String author);
        List<Book> getBooksByNumberOfPagesGreaterThan(Integer pages);
        Book getSearchBookByTitle(String title);


}
