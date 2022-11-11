package model;

import utility.FormatBook;

import java.util.Arrays;

public class Novel extends Book {
    private String publisher;
    private String writer;

    public Novel(String code, String title, Integer publication, String publisher, String writer) {
        super(code, title, publication);
        this.publisher = publisher;
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getWriter() {
        return writer;
    }

    public String toCsv(){
        return String.join(",",
                Arrays.asList(super.getCode(), super.getTitle(),super.getPublication().toString(), publisher, writer,"\n"));
    }
}

