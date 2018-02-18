package app.controller;


import app.entities.Author;
import app.entities.Category;
import app.entities.News;
import app.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DataService dataService;

    @GetMapping("categories")
    public List<Category> categoriesList() { return dataService.getAllCategories(); }

    @GetMapping("news")
    public List<News> newsList() { return dataService.getAllNews(); }

    @GetMapping("authors")
    public List<Author> authorsList() {
        return dataService.getAllAuthors();
    }

    @GetMapping("news/{category}")
    public List<News> fetchResult(@PathVariable String category)
    {
       return dataService.getAllNewsByCategory(category);
    }
}