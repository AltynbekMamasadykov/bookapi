package peaksoft.bookapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.bookapi.models.Book;

public interface BookRepo extends JpaRepository<Book,Long> {
}
