package com.eliseche.drinkingtime.api.model;

import java.util.List;

public class DrinkResult {
    private List<Drink> result;
    private int totalResult;
    private String next;
    private String previous;

    public List<Drink> getResult() {
        return result;
    }

    public void setResult(List<Drink> result) {
        this.result = result;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}