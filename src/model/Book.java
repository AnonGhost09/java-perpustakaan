package model;

public class Book {
    private String code;
    private String title;
    private Integer publication;
    private Integer size;

    public Book(String code, String title, Integer publication, Integer size) {
        this.code = code;
        this.title = title;
        this.publication = publication;
        this.size = size;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPublication() {
        return publication;
    }
}
