package ru.skillbox;

public class Book {
    private final String titleName;
    private final String author;
    private final int pages;
    private final int numberISBN;

    public Book(String titleName, String author, int pages, int numberISBN) {
        this.titleName = titleName;
        this.author = author;
        this.pages = pages;
        this.numberISBN = numberISBN;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getNumberISBN() {
        return numberISBN;
    }
}
