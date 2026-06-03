package com.limasys.entity;

public class Magazine extends LibraryItem{
    private int issueNumber ;
    private String publisher ;

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String display() {
        return "Magazine{" +
                "id=" + getId() +
                ", publisher='" + getPublisher() + '\'' +
                ", issueNumber=" + issueNumber +
                '}';
    }
}
