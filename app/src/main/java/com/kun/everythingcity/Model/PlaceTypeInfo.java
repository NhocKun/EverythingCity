package com.kun.everythingcity.Model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kunmy on 4/21/2016.
 */
public class PlaceTypeInfo implements Parcelable {
    private int id;
    private String name, code;
    private Bitmap img;

    public PlaceTypeInfo() {
    }

    protected PlaceTypeInfo(Parcel in) {
        id = in.readInt();
        name = in.readString();
        code = in.readString();
        img = in.readParcelable(Bitmap.class.getClassLoader());
    }

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

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(code);
        dest.writeParcelable(img, flags);
    }
}
