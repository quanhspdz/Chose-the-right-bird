package com.example.stupidgame;

import java.io.Serializable;

public class Bird implements Serializable {
    private int id;
    private int imgRes;

    public Bird(int id, int imgRes) {
        this.id = id;
        this.imgRes = imgRes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
