package com.igor.championscrud.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMenssage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMenssage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String menssage) {
        this.errors.add(new FieldMenssage(fieldName, menssage));
    }
}
