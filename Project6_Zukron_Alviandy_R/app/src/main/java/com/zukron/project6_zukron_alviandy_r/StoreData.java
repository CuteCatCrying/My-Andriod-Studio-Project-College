package com.zukron.project6_zukron_alviandy_r;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class StoreData implements Parcelable {
    private String itemTitle;
    private int itemImg;
    private String itemDetail;

    public StoreData(String itemTitle, int itemImg, String itemDetail) {
        this.itemTitle = itemTitle;
        this.itemImg = itemImg;
        this.itemDetail = itemDetail;
    }

    protected StoreData(Parcel in) {
        itemTitle = in.readString();
        itemImg = in.readInt();
        itemDetail = in.readString();
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public int getItemImg() {
        return itemImg;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public static final Creator<StoreData> CREATOR = new Creator<StoreData>() {
        @Override
        public StoreData createFromParcel(Parcel in) {
            return new StoreData(in);
        }

        @Override
        public StoreData[] newArray(int size) {
            return new StoreData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemTitle);
        dest.writeInt(itemImg);
        dest.writeString(itemDetail);
    }
}
