package service;

import model.Book;
import model.Megazine;
import model.Novel;

import java.util.List;

public interface InventoryService {
    void addNovel(Novel novel);
    void addMegazine(Megazine megazine);
    void searchBookByTitle(String title);
    Book searchBookById(Integer id);
    void deleteBook();
    void getAllBook();
    Integer hitungSize();
}
