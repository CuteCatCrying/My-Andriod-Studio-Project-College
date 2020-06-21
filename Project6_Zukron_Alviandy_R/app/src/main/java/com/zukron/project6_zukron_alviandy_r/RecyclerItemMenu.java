package com.zukron.project6_zukron_alviandy_r;

public class RecyclerItemMenu {
    private String listMenu;
    private int imageMenu;

    public RecyclerItemMenu(String listMenu, int imageMenu) {
        this.listMenu = listMenu;
        this.imageMenu = imageMenu;
    }

    public String getListMenu() {
        return listMenu;
    }

    public void setListMenu(String listMenu) {
        this.listMenu = listMenu;
    }

    public int getImageMenu() {
        return imageMenu;
    }

    public void setImageMenu(int imageMenu) {
        this.imageMenu = imageMenu;
    }
}
