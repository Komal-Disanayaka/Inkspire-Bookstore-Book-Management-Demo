package service;

import jakarta.servlet.ServletContext;
import model.Book;
import model.Order;
import data_structures.BookLinkedList;
import data_structures.BookQuickSort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    // Using our custom LinkedList implementation for book storage
    private BookLinkedList books;
    private final String BOOKS_FILE;
    private final ServletContext context;

    public BookService(ServletContext context) {
        this.context = context;
        books = new BookLinkedList();
        // Get the real path of the deployed application
        String realPath = context.getRealPath("/");
        BOOKS_FILE = realPath + "data" + File.separator + "books.txt";
        System.out.println("Books file path: " + BOOKS_FILE); // Debug log
        loadBooks();
    }
