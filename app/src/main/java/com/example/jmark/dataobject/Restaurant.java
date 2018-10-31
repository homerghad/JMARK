package com.example.jmark.dataobject;

import java.lang.String;
import java.lang.Integer;
import java.util.ArrayList;

public class Restaurant {
    private int id;
    private boolean budgetLow, budgetMedium, budgetHigh;
    private String name, address;
    private ArrayList<Integer> tagList;
    private Tag tagSource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBudgetLow() {
        return budgetLow;
    }

    public void setBudgetLow(boolean budgetLow) {
        this.budgetLow = budgetLow;
    }

    public boolean isBudgetMedium() {
        return budgetMedium;
    }

    public void setBudgetMedium(boolean budgetMedium) {
        this.budgetMedium = budgetMedium;
    }

    public boolean isBudgetHigh() {
        return budgetHigh;
    }

    public void setBudgetHigh(boolean budgetHigh) {
        this.budgetHigh = budgetHigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Integer> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<Integer> tagList) {
        this.tagList = tagList;
    }

    public Tag getTagSource() {
        return tagSource;
    }

    public void setTagSource(Tag tagSource) {
        this.tagSource = tagSource;
    }

    public Restaurant(int id, boolean budgetLow, boolean budgetMedium, boolean budgetHigh, String name, String address, Tag tagSource) {
        this.budgetLow = budgetLow;
        this.budgetMedium = budgetMedium;
        this.budgetHigh = budgetHigh;
        this.name = name;
        this.id = id;
        this.address = address;
        this.tagSource = tagSource;
        tagList = new ArrayList<>();
    }

    public void addTag(int tagID) {
        if (tagSource.tagExists(tagID)) {
            if (!tagList.contains(tagID))
                tagList.add(tagID);
        } else {
            tagSource.addTag(tagID, "New Tag");
            tagList.add(tagID);
        }
    }

    public void getTagNames() {
        String names = "";
        for (int i = 0; i < tagList.size(); i++) {
            names += tagSource.getTagName(tagList.get(i));
            names += " ";
        }
        System.out.println(names);
    }

    public void edit(boolean budgetLow, boolean budgetMedium, boolean budgetHigh, String name, String address) {
        this.budgetLow = budgetLow;
        this.budgetMedium = budgetMedium;
        this.budgetHigh = budgetHigh;
        this.name = name;
        this.address = address;
    }


}
