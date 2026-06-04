package com.limasys.entity;

import com.limasys.interfaces.Borrowable;

public class Book extends LibraryItem implements Borrowable {
    private String author ;
    private int isbn ;
    private boolean availability = true ;

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
    public void borrow() {
        availability = false;
    }

    @Override
    public void returnItem() {
        availability = true;
    }

    @Override
    public boolean isAvailable() {
        return availability;
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
