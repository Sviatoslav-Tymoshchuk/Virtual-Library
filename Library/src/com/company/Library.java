package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Library {



    ArrayList<Book> books = new ArrayList();

    ArrayList<Book> borrowList = new ArrayList();



    public Library(int number) {

        String[] bookName = {"Moby Dick", "The great Gatsby", "Harry Potter", "War and Peace",
                "Criment and Punishment", "David Copperfield", "Dracula",

                "The Alchemist", "The Da Vinci Code", "Life of Pi", "Brave new world"};



        Random generate = new Random();

        for (int i = 0; i < number; i++) {

            books.add(new Book(i, bookName[generate.nextInt(bookName.length)]));

        }

    }



    public static Book getBookByName(String name, ArrayList<Book> bookList) {

        Book foundBook = null;

        boolean bookOutStock = true;

        for (int i = 0; i < bookList.size(); i++) {

            if (name == bookList.get(i).name) {

                foundBook = bookList.get(i);

                System.out.println("FOUND! Nr: " + foundBook.number + " Name:" + foundBook.name);

                bookOutStock = false;

            }

        }



        if (bookOutStock) {

            System.out.println("WARNING: Book '" + name + "' is out of stock!");

        }

        return foundBook;

    }



    // by NR

    public void addToBorrowList(int bookNumber, ArrayList<Book> myBookList) {

        boolean isBorrow = true;

        if (borrowList.size() > 0) {

            for (int i = 0; i < borrowList.size(); i++) {

                if (borrowList.get(i).number == bookNumber) {

                    System.out.println("WARNING: Book with number " + bookNumber + " is borrow!");

                    isBorrow = false;

                    break;

                }

            }

        }



        if (isBorrow) {

            for (int i = 0; i < myBookList.size(); i++) {

                if (myBookList.get(i).number == bookNumber) {

                    borrowList.add(myBookList.get(i));

                    System.out.println("INFO: Book with number " + bookNumber + " is added to borrow list");

                    break;

                }

            }

        }

    }



    // by NAME

    public void addToBorrowList(String bookName, ArrayList<Book> myBookList) {

        ArrayList<Book> bookInStock = new ArrayList();



        for (int i = 0; i < myBookList.size(); i++) {

            if (myBookList.get(i).name == bookName) {

                bookInStock.add(myBookList.get(i));

            }

        }



        if (bookInStock.size() > 0) {

            if (borrowList.size() > 0) {

                boolean[] stockIsBorrow = new boolean[bookInStock.size()];

                for (int j = 0; j < bookInStock.size(); j++) {

                    stockIsBorrow[j] = false;

                }

                for (int i = 0; i < borrowList.size(); i++) {

                    for (int j = 0; j < bookInStock.size(); j++) {

                        if (borrowList.get(i).number == bookInStock.get(j).number) {

                            stockIsBorrow[j] = true;

                        }

                    }

                }



                for (int i = 0; i < stockIsBorrow.length; i++) {

                    if (stockIsBorrow[i] == false) {

                        borrowList.add(bookInStock.get(i));

                        System.out.println("INFO: Book '" + bookName + "' is added to borrow list");

                        break;

                    }

                }

            } else {

                borrowList.add(bookInStock.get(0));

                System.out.println("INFO: Book '" + bookName + "' is added to borrow list");

            }

        } else {

            System.out.println("WARNING: Book '" + bookName + "' is out of stock!");

        }

    }



    public static void main(String[] args) {

        Library myLibrary = new Library(10);



        System.out.println();

        System.out.println("------------------------------  Array ----------------------------------------");

        System.out.println("==============================================================================");

        System.out.println("=============================== Library ======================================");

        for (int i = 0; i < myLibrary.books.size(); i++) {

            System.out.println(" Nr: " + myLibrary.books.get(i).number + " Name:" + myLibrary.books.get(i).name);

        }



        System.out.println();

        System.out.println("================== Searching:");

        getBookByName("Moby Dick", myLibrary.books);



        System.out.println();

        System.out.println("================== Borrowing:");

        myLibrary.addToBorrowList(5, myLibrary.books);

        myLibrary.addToBorrowList(7, myLibrary.books);

        myLibrary.addToBorrowList(5, myLibrary.books);

        myLibrary.addToBorrowList("The something", myLibrary.books);

        myLibrary.addToBorrowList("Dracula", myLibrary.books);

        myLibrary.addToBorrowList("Dracula", myLibrary.books);



        System.out.println();

        System.out.println("===================== Library 1 - borrow list ===================================");

        for (int i = 0; i < myLibrary.borrowList.size(); i++) {

            System.out.println(" Nr: " + myLibrary.borrowList.get(i).number + " Name:" + myLibrary.borrowList.get(i).name);

        }



    }

}
