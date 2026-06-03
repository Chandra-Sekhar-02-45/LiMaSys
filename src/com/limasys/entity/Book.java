package com.limasys.entity;

public class Book extends LibraryItem{
    private String author ;
    private int isbn ;
    private boolean availability ;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String display() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", available='" + isAvailability() + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
