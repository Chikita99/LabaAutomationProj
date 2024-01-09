package com.solvd.laba.homesellingcompany.services.interfaces;

public interface Sell {
    void sellEntity(String name, String location, double price);
    void listEntityFeatures(int bedrooms, int bathrooms, int floor);
    void listEntityFeatures(int bedrooms, int bathrooms, boolean garage);
}
