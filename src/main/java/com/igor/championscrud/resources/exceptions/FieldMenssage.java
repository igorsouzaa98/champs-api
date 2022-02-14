package com.igor.championscrud.resources.exceptions;

import java.io.Serializable;

public class FieldMenssage implements Serializable {
    private String fieldName;
    private String menssage;

    public FieldMenssage(){
        super();
    }

    public FieldMenssage(String fieldName, String menssage) {
        this.fieldName = fieldName;
        this.menssage = menssage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }
}
