package app.controller;

import app.entities.News;
import app.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class PageController {

    @Autowired
    private DataService dataService;

    @GetMapping
    public ModelAndView getStartPage() {
        return new ModelAndView("index");
    }

    @GetMapping("news/{news_id}")
    public String articleWithId(@PathVariable Long news_id) {
        return  "news/"+String.valueOf(news_id);
    }

    @ModelAttribute
    @GetMapping("news")
    public ModelAndView articlePostId(@RequestParam("news_id") Long news_id) {
        ModelAndView newsView = new ModelAndView();

        News news = dataService.getNews(news_id);

        if(news != null)
            newsView.setViewName(news.getFullDescription());

        return  newsView;
    }
}