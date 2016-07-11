package com.mav.model;

public interface Observer {
    void handleEvent(int temp, int pressure);
}