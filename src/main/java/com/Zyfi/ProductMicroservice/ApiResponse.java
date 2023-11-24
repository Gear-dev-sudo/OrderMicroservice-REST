package com.Zyfi.ProductMicroservice;
public class ApiResponse<T> {
    private int flag;
    private T data;

    // Constructors, getters, and setters

    public ApiResponse(int flag, T data) {
        this.flag = flag;
        this.data = data;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

