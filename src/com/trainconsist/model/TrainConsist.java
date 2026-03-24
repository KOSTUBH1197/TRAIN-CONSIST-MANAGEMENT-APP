package com.trainconsist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shared train consist model.
 * UC1 starts with an empty dynamic list and later use cases can add bogie logic here.
 */
public class TrainConsist {
    private final List<String> bogies;

    public TrainConsist() {
        this.bogies = new ArrayList<>();
    }

    public void addBogie(String bogieName) {
        bogies.add(bogieName);
    }

    public boolean removeBogie(String bogieName) {
        return bogies.remove(bogieName);
    }

    public boolean hasBogie(String bogieName) {
        return bogies.contains(bogieName);
    }

    public int getBogieCount() {
        return bogies.size();
    }

    public List<String> getBogies() {
        return Collections.unmodifiableList(bogies);
    }
}
