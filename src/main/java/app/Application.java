package app;

import app.config.WebConfig;
import app.entities.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.List;

@SpringBootApplication
public class Application  extends SpringBootServletInitializer {


    private static Logger logger = LoggerFactory.getLogger(Application.class);
    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();
        root.register(WebConfig.class);

        root.refresh();
        root.setServletContext(sc);

        sc.addListener(new ContextLoaderListener(root));

        DispatcherServlet dv =
                new DispatcherServlet(new GenericWebApplicationContext());

        ServletRegistration.Dynamic appServlet = sc.addServlet("content", dv);
        //ServletRegistration.Dynamic appServlet = sc.addServlet("content", new DispatcherServlet(root));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/*");
    }

    public static void main(String[] args)
    {
        //SpringApplication.run(Application.class, args);
        logger.info("Application started...");
        SpringApplication.run(Application.class, args);
        //assert (ctx2 != null);


        //System.in.read();
       // ctx.close();
       // GenericApplicationContext ctx = new AnnotationConfigApplicationContext(app.AppConfig.class);
      //  CategoryDao singerDao = ctx2.getBean(CategoryDao.class);
      //  listSingersWithAlbum(singerDao.findAll());
      //  ctx2.close();
    }


    private static void listSingersWithAlbum(List<Category> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(s -> {
            logger.info(String.valueOf(s.getId()));
            System.out.println(String.valueOf(s.toString()));
        });
    }
}