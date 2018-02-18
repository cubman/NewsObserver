package app.repo;

import app.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.title = :category")
    Category getCategryByName(@Param("category") String category);
}
