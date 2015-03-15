package com.kodepelangi.haltemap.entity;

import java.util.List;

/**
 * Response Entity
 * @author Raka Teja<rakatejaa@gmail.com>
 */
public class Response {
    private List<Halte> result;
    private String error;

    public List<Halte> getResult() {
        return result;
    }

    public void setResult(List<Halte> result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
