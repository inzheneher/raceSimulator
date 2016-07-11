package com.mav.model;

public interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Observer observer);
}
