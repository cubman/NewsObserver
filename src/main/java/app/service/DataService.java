package app.service;


import app.entities.Author;
import app.entities.Category;
import app.entities.News;
import app.repo.AuthorRepository;
import app.repo.CategoryRepository;
import app.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService implements IService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private AuthorRepository authorRepository;

  //  @Autowired
  //  private NewsRepository newsRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> target = new ArrayList();
        categoryRepository.findAll().forEach(target::add);
        return target;
    }

    @Override
    public List<News> getAllNews()
    {
        List<News> target = new ArrayList();
        newsRepository.findAll().forEach(target::add);
        return target;
    }

    @Override
    public List<Author> getAllAuthors()
    {
        List<Author> target = new ArrayList();
        authorRepository.findAll().forEach(target::add);
        return target;
    }

   /* @Override
    public List<News> getAllNews()
    {
        List<News> target = new ArrayList();
        newsRepository.findAll().forEach(target::add);
        return target;
    }*/
   @Override
   public News getNews(Long news_id)
   {
       return newsRepository.findOne(news_id);
   }

    @Override
    public List<News> getAllNewsByCategory(String category)
    {
        List<News> target = new ArrayList();

        Category c = categoryRepository.getCategryByName(category);

        getAllNews().forEach(art -> {if (art.getCategories().contains(c)) target.add(art);});
        return target;
    }
}
