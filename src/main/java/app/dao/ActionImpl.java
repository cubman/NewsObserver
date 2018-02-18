package app.dao;

import app.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@SuppressWarnings("unchecked")
@Transactional
@Repository("categoryDao")
public class ActionImpl implements ActionDao
{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Category> findAll()
    {
        Session s = sessionFactory.getCurrentSession();
        List<Category> lc = s.createQuery("from Category c").list();
      //  s.close();
        return lc;
    }

  /*  public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/
}