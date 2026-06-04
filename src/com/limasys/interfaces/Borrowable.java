package com.limasys.interfaces;

public interface Borrowable {

    void borrow();

    void returnItem();

    boolean isAvailable();
}