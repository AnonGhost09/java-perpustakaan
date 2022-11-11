package service;

import model.Book;
import model.Megazine;
import model.Novel;
import repository.InventoryRepository;
import repository.InventoryRepositoryImpl;

import java.util.List;

public class InventoryServiceImpl implements  InventoryService{

    InventoryRepository inventoryRepository = new InventoryRepositoryImpl("book.csv");

    @Override
    public void addNovel(Novel novel) {
        inventoryRepository.addNovel(novel);
        System.out.println("Berhasil");
    }

    @Override
    public void addMegazine(Megazine megazine) {
        inventoryRepository.addMegazine(megazine);
        System.out.println("Berhasil");
    }

    @Override
    public List<Novel> searchBookByTitle(String title) {
        return inventoryRepository.searchBookByTitle(title);
    }

    @Override
    public Book searchBookById(Integer id) {
        return null;
    }

    @Override
    public void deleteBook() {
        inventoryRepository.delete();
        System.out.println("Berhasil dihapus");
    }

    @Override
    public void getAllBook() {
        List result = inventoryRepository.findAll();
        for (String data : result
             ) {

        }
    }

    @Override
    public Integer hitungSize() {
        return inventoryRepository.getSize();
    }
}
