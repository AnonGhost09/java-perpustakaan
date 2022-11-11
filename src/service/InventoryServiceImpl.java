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
    public void searchBookByTitle(String title) {
        List<Novel> result = inventoryRepository.searchBookByTitle(title);

        Integer i = 0;
        for (var data :
                result) {
            i++;
            System.out.println(i);
            System.out.println("Title : "+data.getTitle());
            System.out.println("Publication : "+data.getPublication());
            System.out.println("Writer : "+data.getWriter());
            System.out.println("Publisher : "+data.getPublisher());
        }

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
        List<Novel> result = inventoryRepository.findAll();
        Integer i = 0;
        for (var data :
                result) {
            i++;
            System.out.println(i);
            System.out.println("Title :"+data.getTitle());
            System.out.println("Publication :"+data.getPublication());
            System.out.println("Writer : "+data.getWriter());
            System.out.println("Publisher : " + data.getPublisher());
        }
    }

    @Override
    public Integer hitungSize() {
        return inventoryRepository.getSize();
    }
}
