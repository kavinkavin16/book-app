package com.chainsys.book.test;
import java.io.*;
import java.util.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;
import com.chainsys.book.dao.*;

public class BookClient  {

	
	public static void main(String[] args)
	{

		Set<Book> bookSet;
		List<String> namelist;
		List<Integer> idlist;
		BookService service = new BookServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println(" 1. Find the Book By Id");
		System.out.println(" 2. Find the Book By Id");
		System.out.println(" 3. Find the Product By Name");
		

		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
			switch (choice) {
			case 1:
				System.out.println("Find All Books");
				bookSet = service.findAll();
				System.out.println(bookSet);
				break;
			case 2:
				System.out.println("Find the Product By Id");
				System.out.println("Enter the Product Id");
				id = scanner.nextInt();
				try {
					Book book = service.findById(id);
					System.out.println(book);
				} catch (BookNotFoundException e) {
				}
				break;
			case 3:
				System.out.println("Find the Product By Name");
				System.out.println("Enter the Product Name");
				String name = scanner.next();
				try {
					Book book = service.findByName(name);
					System.out.println(book);
				} catch (BookNotFoundException e) {
				}
				break;
		default:
					break;
					
					}

		
	}
}
