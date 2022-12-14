package model;

import utility.FormatBook;

import java.util.Arrays;

public class Megazine extends Book {
    private String publishPeriode;

    public Megazine(String code, String title, Integer publication,  String publishPeriode) {
        super(code, title, publication);
        this.publishPeriode = publishPeriode;
    }

    public String getPublishPeriode() {
        return publishPeriode;
    }

    public String toCsv(){
        return String.join(",",
                Arrays.asList(super.getCode(), super.getTitle(),super.getPublication().toString(), publishPeriode,"\n"));
    }

}