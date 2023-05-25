package com.example.week4_ex1.Repository;

import com.example.week4_ex1.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
    Librarian getLibrarianById(Integer id);
    Librarian getLoginByUserNameAndPassword(String username, String password);

  List <Librarian>getLibrarianByEmail(String email);



}