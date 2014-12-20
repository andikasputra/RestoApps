package com.bytech.controls;

import java.util.List;

import com.bytech.models.Cats;

public interface CatsInterface {

    void add(Cats c);

    void update(String key, Cats a);

    void remove(String key);

    String get(String key);

    List<Cats> get();

}
