package com.kun.everythingcity.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kunmy on 4/21/2016.
 */
public class PlaceTypeInfo implements Parcelable {


    public static final Creator<PlaceTypeInfo> CREATOR = new Creator<PlaceTypeInfo>() {
        @Override
        public PlaceTypeInfo createFromParcel(Parcel in) {
            return new PlaceTypeInfo(in);
        }

        @Override
        public PlaceTypeInfo[] newArray(int size) {
            return new PlaceTypeInfo[size];
        }
    };
    private int id, img;
    private String name, code;

    public PlaceTypeInfo() {
    }

    protected PlaceTypeInfo(Parcel in) {
        id = in.readInt();
        name = in.readString();
        code = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(img);
        parcel.writeString(name);
        parcel.writeString(code);
    }
}
