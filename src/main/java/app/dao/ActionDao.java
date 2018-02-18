package app.dao;

import app.entities.Category;

import java.util.List;

public interface ActionDao {

    List<Category> findAll();
}
