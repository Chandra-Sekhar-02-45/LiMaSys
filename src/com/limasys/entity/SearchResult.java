package com.limasys.entity;

import java.util.List;

public class SearchResult<T> {

    private List<T> results;
    private String query;

    public SearchResult(List<T> results, String query) {
        this.results = results;
        this.query = query;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}