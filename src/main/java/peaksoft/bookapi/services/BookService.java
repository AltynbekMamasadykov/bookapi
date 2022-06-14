package peaksoft.bookapi.services;

import org.springframework.stereotype.Service;
import peaksoft.bookapi.dto.request.BookSaveRequest;
import peaksoft.bookapi.dto.response.SimpleResponse;
import peaksoft.bookapi.exceptions.BookNotFoundException;
import peaksoft.bookapi.models.Book;
import peaksoft.bookapi.repositories.BookRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    //methods

    public List<Book> findAll() {
        return bookRepo.findAll();
    }


    public Book findById(Long bookId) {

//        boolean exists = bookRepo.existsById(bookId);
//
//        if(!exists){
//            throw new BookNotFoundException(
//                    "Book with id =  " + bookId + " not found"
//            );
//        }
//        return bookRepo.getById(bookId);

        return getBookById(bookId);

    }

    private Book getBookById(Long bookId){
        return bookRepo.findById(bookId).orElseThrow(
                () -> new BookNotFoundException
                        (
                                "Book with id =  " + bookId + " not found"
                        )
        );
    }


    public Book save(BookSaveRequest bookSaveRequest) {
        Book book = new Book();
        book.setName(bookSaveRequest.getName());
        book.setAuthor(bookSaveRequest.getAuthor());
        book.setPrice(bookSaveRequest.getPrice());
        return bookRepo.save(book);
    }

    public SimpleResponse deleteById(Long bookId) {

        boolean exists = bookRepo.existsById(bookId);

        if(!exists){
            throw new BookNotFoundException(
                    "Book with id =  " + bookId + " not found"
            );
        }

        bookRepo.deleteById(bookId);

        return new SimpleResponse(
                "DELETED",
                "Successfully deleted book!"
        );

    }

    @Transactional
    public Book updateBookById(Long bookId, BookSaveRequest bookSaveRequest) {
        Book book = getBookById(bookId);

        String currentName = book.getName();
        String newName = bookSaveRequest.getName();
        if(newName != null && !currentName.equals(newName)){
            book.setName(newName);
        }

        String currentAuthorName = book.getAuthor();
        String newAuthorName = bookSaveRequest.getAuthor();
        if(newAuthorName != null && !currentAuthorName.equals(newAuthorName)){
            book.setAuthor(newAuthorName);
        }

        book.setPrice(bookSaveRequest.getPrice());

        return book;
    }
}
