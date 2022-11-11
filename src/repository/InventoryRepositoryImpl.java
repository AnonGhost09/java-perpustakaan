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

    public boolean cekUniqueId(String id){
        var result = getListBook();
        boolean cek = false;
        for (var data :
                result) {
            if (data.equals(id)) {
                cek = true;
                break;
            }
        }
        return cek;
    }

    public List<Book> getListBook(){
        var result = readData().map(p -> {
            String[] temp = p.split(",");
            if (temp[0].matches(".*\\b-B-\\b.*"))
                return new Megazine(temp[0], temp[1], Integer.valueOf(temp[2]), temp[3]);
            return new Novel(temp[0], temp[1], Integer.valueOf(temp[2]), temp[3], temp[4]);
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public Integer getSize() {
        return readData().collect(Collectors.toList()).size();
    }


    @Override
    public void addNovel(Novel novel) {
        if(!cekUniqueId(novel.getCode())){
            insertData(novel.toCsv());
        }
        System.out.println("ID NOVEL SUDAH TERDAFTAR");
    }

    @Override
    public void addMegazine(Megazine megazine) {
        if(!cekUniqueId(megazine.getCode())){
            insertData(megazine.toCsv());
        }
        System.out.println("ID MEGAZINE SUDAH TERDAFTAR");
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        var result = readData().map(p -> {
            String[] temp = p.split(",");
            if(temp[0].matches(".*\\b-B-\\b.*")) return new Megazine(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3]);
            return new Novel(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3],temp[4]);
        }).filter(n -> n.getTitle().equals(title)).collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Book> findAll() {
        var result = readData().map(p -> {
            String[] temp = p.split(",");
            if(temp[0].matches(".*\\b-B-\\b.*")) return new Megazine(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3]);
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
    public List<Book> findBydId() {
      var result = readData().map(p -> {
            String[] temp = p.split(",");
          if(temp[0].matches(".*\\b-B-\\b.*")) return new Megazine(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3]);
            return new Novel(temp[0],temp[1],Integer.valueOf(temp[2]),temp[3],temp[4]);
        }).collect(Collectors.toList());
        return result;
    }
}
