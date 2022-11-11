package repository;

import model.Book;
import model.Megazine;
import model.Novel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryRepositoryImpl implements InventoryRepository {
    private final Path path;

    public InventoryRepositoryImpl(String path) {
        try{
            this.path = Paths.get(path);
            boolean isNewFileExists = Files.exists(this.path);
            if(!isNewFileExists) Files.createFile(this.path);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private Stream<String> readData(){
        try{
            return Files.lines(path);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void writeData(String content){
        try{
            Files.write(path,content.getBytes(StandardCharsets.UTF_8));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void insertData(String content){
        try{
            Files.write(path,content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getSize() {
        return readData().collect(Collectors.toList()).size();
    }

    @Override
    public void addNovel(Novel novel) {
        insertData(novel.toCsv());
    }

    @Override
    public void addMegazine(Megazine megazine) {
        insertData(megazine.toCsv());
        System.out.println("Berhasil");
    }

    @Override
    public List<Novel> searchBookByTitle(String title) {
        List<Novel> result = readData().map(p -> {
            String[] temp = p.split(",");
            return new Novel(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3],temp[4]);
        }).filter(n -> n.getTitle().equals(title)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Novel> findAll() {
        List<Novel> result = readData().map(p -> {
            String[] temp = p.split(",");
            return new Novel(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3],temp[4]);
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public void delete() {
        List result= readData().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.toList());
        writeData(String.join("\n",result));
    }

    @Override
    public Novel findByIndex(Integer idx) {

    }
}
