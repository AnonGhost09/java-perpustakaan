package service;

import model.Book;
import model.Megazine;
import model.Novel;

import java.util.List;

public interface InventoryService {
    void addNovel(Novel novel);
    void addMegazine(Megazine megazine);
    void searchBookByTitle(String title);
    void searchBookById(String id);
    void deleteBook();
    void getAllBook();
    Integer hitungSize();
}
