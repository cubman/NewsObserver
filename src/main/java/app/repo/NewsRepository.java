package app.repo;

import app.entities.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {

   // @Query("SELECT a.id FROM News a WHERE (SELECT COUNT(art.id) FROM CATEGORY_ARTICLE cat_art JOIN News art ON  art.id = cat_art.article_id WHERE cat_art.article_id = a.id AND cat_art.category_id = (SELECT c.id FROM Category c WHERE c.title = :category)) > 0")
   // public Iterable<Long> getArticleByCategry(@Param("category") String category);

    //@Query("SELECT c FROM Category c WHERE c.title = :category")
   // public Iterable<Category> getArticleByCategry(@Param("category") String category);
}
