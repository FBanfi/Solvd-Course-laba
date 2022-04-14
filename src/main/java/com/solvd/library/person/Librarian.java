package com.solvd.library.person;

import com.solvd.library.book.Book;
import com.solvd.library.bookRequest.BookRequest;
import com.solvd.library.bookshelf.AdultBookshelf;
import com.solvd.library.bookshelf.Bookshelf;
import com.solvd.library.bookshelf.ChildBookshelf;
import com.solvd.library.functionalInterfaces.IClose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//SINGLETON
public class Librarian extends Person {
    private static final Librarian INSTANCE = new Librarian();
    private List<Bookshelf> bookshelfs = new ArrayList<>();
    private LevelOfAccess level = LevelOfAccess.CASH_AND_BOOKSHELFS; //level of access to the library, the manager can change his access but for default it is in BOOKSHELF AND CASH

    public static Librarian instance() {
        return INSTANCE;
    }

    public void closeLibrary(IClose closer) {
        closer.closeLibrary();
    }

    @Override
    public List<Book> findInformation(String topic) {
        if (level.equals(LevelOfAccess.BOOKSHELFS) || level.equals(LevelOfAccess.ALL_LIBRARY) ||
                level.equals(LevelOfAccess.CASH_AND_BOOKSHELFS) && level.getNumberOfKeys() > 0)
            return findTopicInBookshelfs(topic);
        else
            return null;
    }

    public Book findInBookShelf(BookRequest bookRequest, Client client) {
        List<Book> books = booksAvailable(bookRequest, client).stream().filter(book -> book.getName().equals(bookRequest.getName())).collect(Collectors.toList());
        return validateOtherFields(books.stream().findFirst().get(), bookRequest);
    }

    public List<Book> findTopicInBookshelfs(String topic) {
        List<Book> booksOfThatTopic = new ArrayList<Book>();
        booksAvailable().stream().forEach(book -> {
            if (book.getTopic().equals(topic)) {
                booksOfThatTopic.add(book);
            }
        });
        return booksOfThatTopic;
    }

    //OVERLOADING METHODS
    private List<Book> booksAvailable() {
        List<Book> allBooks = new ArrayList<Book>();
        bookshelfs.forEach(bookshelf -> allBooks.addAll(bookshelf.getBooksAvailable()));
        return allBooks;
    }

    private List<Book> booksAvailable(BookRequest bookRequest, Client client) {
        List<Book> booksWanted = new ArrayList<>();
        TypeOfAuthorContent content = bookRequest.getAuthor().getContent();
        if (content.toString().equals("ADULT") && client.getAge() >= content.getMinimunAge()) {
            bookshelfs.stream().forEach(bookshelf -> {
                bookshelf.getClass().equals(AdultBookshelf.class);
                booksWanted.addAll(bookshelf.getBooksAvailable());
            });
        } else {
            bookshelfs.stream().forEach(bookshelf -> {
                bookshelf.getClass().equals(ChildBookshelf.class);
                booksWanted.addAll(bookshelf.getBooksAvailable());
            });
        }
        return booksWanted;
    }

    private Book validateOtherFields(Book book, BookRequest bookRequest) {
        if (compareAuthor(book, bookRequest) && compareType(book, bookRequest) && comparePages(book, bookRequest)) {
            return book;
        }
        return null;
    }

    private Boolean compareAuthor(Book book, BookRequest bookRequest) {
        return book.getAuthor().getName().equals(bookRequest.getAuthor().getName());
    }

    private Boolean compareType(Book book, BookRequest bookRequest) {
        return book.getType().equals(bookRequest.getPreference());
    }

    private Boolean comparePages(Book book, BookRequest bookRequest) {
        return book.getPages() == bookRequest.getPages();
    }

    private Boolean compareTopics(Book book, BookRequest bookRequest) {
        return book.equals(bookRequest.getPages());
    }

    public List<Bookshelf> getBookshelfs() {
        return bookshelfs;
    }

    public void setBookshelfs(List<Bookshelf> bookshelfs) {
        this.bookshelfs = bookshelfs;
    }

    public void addToBookshelf(Book newBook, Bookshelf bookshelf) {
        bookshelf.getBooksAvailable().add(newBook);
    }

    public void removeFromBookshelf(Book oneBook, Bookshelf bookshelf) {
        bookshelf.getBooksAvailable().remove(oneBook);
    }

    public void addBookshelf(Bookshelf newBookshelf) {
        bookshelfs.add(newBookshelf);
    }

    public void removeBookshelfs(Bookshelf aBookShelf) {
        bookshelfs.remove(aBookShelf);
    }
}
