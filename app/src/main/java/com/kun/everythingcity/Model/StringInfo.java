package com.kun.everythingcity.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kunmy on 4/21/2016.
 */
public class StringInfo implements Parcelable {
    private String time;

    public StringInfo() {
    }

    protected StringInfo(Parcel in) {
        time = in.readString();
    }

    public static final Creator<StringInfo> CREATOR = new Creator<StringInfo>() {
        @Override
        public StringInfo createFromParcel(Parcel in) {
            return new StringInfo(in);
        }

        @Override
        public StringInfo[] newArray(int size) {
            return new StringInfo[size];
        }
    };

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
    }
}
