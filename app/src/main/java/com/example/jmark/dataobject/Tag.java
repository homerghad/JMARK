package com.example.jmark.dataobject;

import java.util.HashMap;
import java.util.Map;

public class Tag {
    private Map<Integer, String> tagMap;

    public Tag() {
        this.tagMap = new HashMap<Integer, String>();
    }

    public void addTag(int id, String tagName) {
        tagMap.put(id, tagName);
    }

    public String getTagName(int id) {
        return tagMap.get(id);
    }

    public boolean tagExists(int id) {
        return tagMap.containsKey(id);
    }
}
