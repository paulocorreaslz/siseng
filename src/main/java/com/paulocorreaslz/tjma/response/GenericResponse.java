package com.paulocorreaslz.tjma.response;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
public class GenericResponse<T> {

    private T data;
    private List<String> errors = new ArrayList<>();

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "GenericResponse{" + "data=" + data + ", errors=" + errors + '}';
    }
}
