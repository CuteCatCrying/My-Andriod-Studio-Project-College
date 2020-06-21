package com.zukron.quizzukronalviandyr;

public class Makanan {
    private String no;
    private String title;
    private int img;
    private String description;
    private String price;

    public Makanan(String no, String title, int img, String description, String price) {
        this.no = no;
        this.title = title;
        this.img = img;
        this.description = description;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
