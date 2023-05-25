package com.example.week4_ex1.Service;


import com.example.week4_ex1.ApiException.ApiException;
import com.example.week4_ex1.Model.Librarian;
import com.example.week4_ex1.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

   @Service
    @RequiredArgsConstructor
    public class LibrarianService {
        private final LibrarianRepository librarianRepository;

        public List<Librarian> getAll(){
            return librarianRepository.findAll();
        }


        public void addLibrarian(Librarian librarian){
            librarianRepository.save(librarian);
        }
        public void updateLibrarian(Integer id, Librarian librarian){
            Librarian old = librarianRepository.getLibrarianById(id);
            if (old==null){
                throw new ApiException("Librarian not found");
            }
            old.setId(librarian.getId());
            old.setName(librarian.getName());
            old.setUsername(librarian.getUsername());
            old.setPassword(librarian.getPassword());
            old.setEmail(librarian.getEmail());
            librarianRepository.save(old);
        }


        public void deleteLibrarian(Integer id){
            Librarian old=librarianRepository.getLibrarianById(id);
            if (old==null){
                throw new ApiException("Wrong Deleted");
            }

            librarianRepository.delete(old);
        }
    public Librarian  getLibrarianById(Integer id){
        Librarian librarian=librarianRepository. getLibrarianById(id);
        if (librarian== null){
            throw new ApiException("Not Found");
        }
        return librarian;
    }

    public Librarian getLoginByUserNameAndPassword(String username, String password){
        Librarian librarian=librarianRepository.getLoginByUserNameAndPassword(username,password);
        if (librarian==null){
            throw new ApiException("Not Found");
        }
        return librarian;
    }
    public List<Librarian>getLibrarianByEmail(String email){
        List<Librarian>librarians=librarianRepository.getLibrarianByEmail(email);
        if (librarians==null){
            throw new ApiException("Not Found");
        }
        return librarians;

    }
}
