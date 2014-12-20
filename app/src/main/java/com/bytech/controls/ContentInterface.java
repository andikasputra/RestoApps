package com.bytech.controls;

import java.util.List;

import com.bytech.models.Content;

public interface ContentInterface {

    void add(Content c);

    void update(String key, Content c);

    void remove(String key);

    Content getDetail(int id);

    List<Content> get(int cid);

    List<Content> getId(int id);

}
