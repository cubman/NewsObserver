package app.service;

import app.entities.Author;
import app.entities.Category;
import app.entities.News;

import java.util.List;

public interface IService {

    List<Category> getAllCategories();

    List<News> getAllNews();

    List<Author> getAllAuthors();

    News getNews(Long news_id);

    List<News> getAllNewsByCategory(String category);
}
