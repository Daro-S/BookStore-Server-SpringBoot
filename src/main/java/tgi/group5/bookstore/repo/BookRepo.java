package tgi.group5.bookstore.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tgi.group5.bookstore.model.Bookstore;

public interface BookRepo extends JpaRepository<Bookstore, Long>{
        void deleteBookById(long id);
        Optional<Bookstore> findBookById(long id);
    
}
