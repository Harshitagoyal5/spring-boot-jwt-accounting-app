package com.alibou.security.payload;

import java.util.Map;

public class Data<T> {
    T data;
    String name;
    Map<String, String> extData;

    public void setExtData(Map<String, String> extData) {
        this.extData = extData;
    }


    public Data(String name, T data, Map<String, String> extData) {
        this.data = data;
        this.name = name;
        this.extData = extData;
    }

    public Map<String, String> getExtData() {
        return extData;
    }

    public String getName() {
        return name;
    }

    public T getData() {
        return data;
    }
}

