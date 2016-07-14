package com.mav.model;

public interface Observed {
    void addObserver(RaceListener observer);

    void removeObserver(RaceListener observer);

    void notifyObserver(RaceListener observer);
}
