package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.chainsys.book.model.Book;

public class BookDAOImpl implements BookDAO{
	
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static ArrayList<String> namelist; //unused
	private static ArrayList<Integer> idlist;	//unused
	
	
	
	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public Set<Book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from book_2595");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("id"), rs.getString("name"),
						rs.getDate("publisheddate").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}

	@Override
	public Book findById(int id) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2595 where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("publisheddate").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book findByName(String name) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2595 where name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("publisheddate").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

}
