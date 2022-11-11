package repository;

import model.Book;
import model.Megazine;
import model.Novel;

import java.util.List;

public interface InventoryRepository {
    void addNovel (Novel novel);
    Integer getSize();
    void addMegazine (Megazine megazine);
    List<Novel> searchBookByTitle(String title);
    List<Book> findAll();
    void delete();
    Book findByIndex(Integer idx);
}
