package com.solvd.library.main;

import com.solvd.library.book.*;
import com.solvd.library.bookshelf.AdultBookshelf;
import com.solvd.library.bookshelf.Bookshelf;
import com.solvd.library.bookshelf.ChildBookshelf;
import com.solvd.library.bookshelf.cleaning.HighAltitude;
import com.solvd.library.bookshelf.cleaning.LowAltitude;
import com.solvd.library.bookshelf.cleaning.MediumAltitud;
import com.solvd.library.person.Author;
import com.solvd.library.person.Client;
import com.solvd.library.person.Librarian;
import com.solvd.library.person.TypeOfAuthorContent;
import com.solvd.library.person.document.Dni;
import com.solvd.library.person.document.Document;
import com.solvd.library.person.document.Passport;
import com.solvd.library.person.payment.Card;
import com.solvd.library.person.payment.Cash;
import com.solvd.library.supplier.Invoice;
import com.solvd.library.supplier.Supplier;
import com.solvd.library.supplier.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class);

    //BUSINESS QUESTION: (Try to find a books or any other information for person based on their preferences)
    public static void main(String[] args) {

        Dni dni = new Dni();
        Passport passport = new Passport();
        Document documentFran = new Document(dni, "42045030");
        Document documentCoco = new Document(passport, "410045030");

        Author jkRolling = new Author("Joanne Rowling", 56,"England", false, documentFran, new ArrayList<Book>(), new ArrayDeque<Book>(), TypeOfAuthorContent.CHILD, 10);
        Author stephenKing = new Author("Stephen King", 76, "EEUU", false, documentFran, new ArrayList<Book>(), new ArrayDeque<Book>(), TypeOfAuthorContent.ADULT, 9);

        Book harryPotter1 = new EspecialEditionBook("Harry Potter and the goblet of fire", 400, jkRolling,
                "An epic magical tournament!", TypeOfBook.FANTASY, "Hallowen", 400, 50);
        Book harryPotter2 = new HardCoverBook("Harry Potter and the chamber of secrets", 400, jkRolling,
                "An epic magical tournament!", TypeOfBook.FANTASY, 10, 450);
        Book it = new BasicBook("It", 500, stephenKing,
                "Entertainment", TypeOfBook.HORROR, 300);

        HighAltitude highAltitudeRoom1 = new HighAltitude();
        MediumAltitud mediumAltitudRoom1 = new MediumAltitud();
        LowAltitude lowAltitudeRoom1 = new LowAltitude();

        LocalDate someTimeAgo = LocalDate.of(2020, 9, 1);

        LinkedList linkedList1 = new LinkedList<Book>();
        linkedList1.add(harryPotter1);
        linkedList1.add(harryPotter2);
        linkedList1.add(it);

        Bookshelf childBookShelf1 = new ChildBookshelf(linkedList1, highAltitudeRoom1, someTimeAgo);
        Bookshelf adultBookShelf1 = new AdultBookshelf(linkedList1, mediumAltitudRoom1, someTimeAgo);
        Bookshelf adultBookShelf2 = new AdultBookshelf(linkedList1, lowAltitudeRoom1, someTimeAgo);

        List<Book> list1 = new ArrayList<Book>();
        list1.add(harryPotter1);
        list1.add(harryPotter2);
        list1.add(it);

        Ticket<LinkedList<Book>> ticket = new Ticket<LinkedList<Book>>(2500, linkedList1);
        Invoice<List<Book>> invoice = new Invoice<List<Book>>(LocalDate.now().plusMonths(2), false, 3000, list1);

        Supplier supplier1 = new Supplier(adultBookShelf2, ticket);
        Supplier supplier2 = new Supplier(adultBookShelf2, invoice);

        childBookShelf1.addBookToBookshelf(harryPotter1);
        childBookShelf1.addBookToBookshelf(harryPotter2);
        adultBookShelf1.addBookToBookshelf(it);
        adultBookShelf2.addBookToBookshelf(it);
        adultBookShelf2.addBookToBookshelf(harryPotter1);

        Librarian.instance().addBookshelf(childBookShelf1);
        Librarian.instance().addBookshelf(adultBookShelf1);

        Cash cash1 = new Cash(50);
        Card card1 = new Card(50);

        Client fran = new Client("Franco", 21, "Garibaldi 1944", false, documentFran, new Stack<Book>(),
                new Stack<Book>(), false, 1500, cash1);
        fran.addToOwnedBooks(harryPotter1);
        fran.addToOwnedBooks(harryPotter2);
        Client coco = new Client("Coco", 21, "Medrano 1944", false, documentCoco, new Stack<Book>(),
                new Stack<Book>(), false, 1000, card1);
        coco.addToOwnedBooks(harryPotter1);
        coco.addToOwnedBooks(it);

        //BUSINESS QUESTION IMPLEMENTATION

        //CLIENT
        //FIND INFORMATION
        List<Book> books = coco.findInformation("Entertainment");
        LOGGER.info("The books that contains information about the topic you want are this ones: ");
        List<String> namesSeen = new ArrayList<String>();
        for (Book book : books) {
            if (namesSeen.contains(book.getName())) {
                continue;
            } else {
                LOGGER.info("Name: " + book.getName() + ", " + "type: " + book.getType().getValue());
                namesSeen.add(book.getName());
            }
        }

        LOGGER.info("You can buy them");

        //FIND BOOK
        Book requestedBook = coco.findBook("Harry Potter and the goblet of fire", TypeOfBook.FANTASY, 400, jkRolling);
        LOGGER.info("The book you have requested is this one " + requestedBook);

        //BUY BOOK
        coco.buyBook(requestedBook);
        LOGGER.info("The librarian will give you the book to you in a second when he verify the payment");

        //LIBRARIAN
        //GET SUPPLYMENT
        supplier1.supplyLibrary();
        LOGGER.warn("Check if the books that the supplier gave to you are already charged in the system!!");
        List<Bookshelf> allBookshelf = Librarian.instance().getBookshelfs();
        //CLEAN BOOKSHELFS
        allBookshelf.get(allBookshelf.size() - 1).cleanBookshelf();
    }
}
