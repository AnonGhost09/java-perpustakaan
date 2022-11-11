package model;

public class Book {
    private String code;
    private String title;
    private Integer publication;

    private Megazine megazine;

    private Novel novel;

    public Book(String code, String title, Integer publication) {
        this.code = code;
        this.title = title;
        this.publication = publication;
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

    public Megazine getMegazine() {
        return megazine;
    }

    public Novel getNovel() {
        return novel;
    }
}
