package com.example.week4_ex1.Controller;

import com.example.week4_ex1.Model.Librarian;
import com.example.week4_ex1.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;
//All CRUD
    @GetMapping("/get1")
    public ResponseEntity getAll(){
        List<Librarian> librarians = librarianService.getAll();
        return ResponseEntity.status(200).body(librarians);
    }
    @PostMapping("/add1")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian added");
    }
    @PutMapping("/update1/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @Valid @RequestBody Librarian librarian){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("Librarian updated");
    }
    @DeleteMapping("/delete1/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted");
    }

    @GetMapping("/get1-id")
    public ResponseEntity getLibrarianById(@PathVariable Integer id){
        Librarian librarian=librarianService.getLibrarianById(id);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/check/{name}/{password}")
    public ResponseEntity getLoginByUserNameAndPassword(@PathVariable String username, @PathVariable String password){
        Librarian librarian=librarianService.getLoginByUserNameAndPassword(username,password);
        return ResponseEntity.status(200).body(librarian);
    }
    @GetMapping("/get-by-email/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email){
        List <Librarian> librarians=librarianService.getLibrarianByEmail(email);
        return ResponseEntity.status(200).body(librarians);
    }
}
