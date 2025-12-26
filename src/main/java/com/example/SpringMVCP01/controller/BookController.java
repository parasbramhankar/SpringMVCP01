package com.example.SpringMVCP01.controller;

import com.example.SpringMVCP01.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BookController {

    private List<Book>bookList=new ArrayList<>();

    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookList);
        return "books";
    }


    /*
 WHY WE USE BOTH @GetMapping AND @PostMapping WITH SAME "/add-book" URL

 1) @GetMapping("/add-book")
    - Used to DISPLAY the add-book form (add-book.html)
    - Called when user opens the page in browser
    - Sends an empty Book object to bind form fields
    - This method should NEVER modify data (READ operation)

 2) @PostMapping("/add-book")
    - Used to HANDLE form submission
    - Called when user clicks the Submit button
    - Receives form data and converts it into Book object
    - Saves the book data (WRITE operation)
    - Redirects to "/books" after successful submission

 WHY SAME URL?
 - Both methods represent the SAME resource: "add-book"
 - HTTP METHOD decides the action:
      GET  -> show form
      POST -> submit data

 BENEFITS:
 - Follows HTTP & REST standards
 - Prevents duplicate form submission (PRG pattern)
 - Clean, readable, professional code
 - Industry best practice

 REAL-LIFE ANALOGY:
 - GET  : Ask for a blank form
 - POST : Submit the filled form
*/



    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book){
        bookList.add(book);

        return "redirect:/books";
    }


    @GetMapping("/add-book")
    public String showAllAddedBooks(Model model){
        model.addAttribute("book",new Book());
        return "add-book";
    }


}
