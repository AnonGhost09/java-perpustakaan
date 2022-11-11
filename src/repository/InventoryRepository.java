package repository;

import model.Book;
import model.Megazine;
import model.Novel;

import java.util.List;

public interface InventoryRepository{
    void addNovel (Novel novel);
    Integer getSize();
    void addMegazine (Megazine megazine);
    List<Book> searchBookByTitle(String title);
    List<Book> findAll();
    void delete();
    List<Book> findBydId();
}
