package peaksoft.bookapi.apis;

import org.springframework.web.bind.annotation.*;
import peaksoft.bookapi.dto.request.BookSaveRequest;
import peaksoft.bookapi.dto.response.SimpleResponse;
import peaksoft.bookapi.models.Book;
import peaksoft.bookapi.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookApi {

    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    //methods

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/find/{bookId}")
    public Book findById(@PathVariable Long bookId){
        return bookService.findById(bookId);
    }

    @PostMapping("/save")
    public Book save(@RequestBody BookSaveRequest bookSaveRequest){
        return bookService.save(bookSaveRequest);
    }

    @DeleteMapping("/delete/{bookId}")
    public SimpleResponse deleteBookById(@PathVariable Long bookId){
        return bookService.deleteById(bookId);
    }

    @PutMapping("/update/{bookId}")
    public Book updateBookById(@PathVariable Long bookId,@RequestBody BookSaveRequest bookSaveRequest){
        return bookService.updateBookById(bookId,bookSaveRequest);
    }

}
