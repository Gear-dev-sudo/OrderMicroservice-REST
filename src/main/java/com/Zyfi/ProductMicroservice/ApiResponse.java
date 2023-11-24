package com.Zyfi.ProductMicroservice;
public class ApiResponse{
    private int flag;
    Object data;

    // Constructors, getters, and setters



    public ApiResponse() {
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

