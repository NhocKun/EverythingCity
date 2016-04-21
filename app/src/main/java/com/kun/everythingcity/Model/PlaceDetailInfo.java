package com.kun.everythingcity.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kunmy on 4/21/2016.
 */
public class PlaceDetailInfo implements Parcelable {
    private String name, formatted_address, formatted_phone_number, lat, lng, icon, id, open_now, rating, reference, author_name, author_url, text, website;

    public PlaceDetailInfo() {
    }

    protected PlaceDetailInfo(Parcel in) {
        name = in.readString();
        formatted_address = in.readString();
        formatted_phone_number = in.readString();
        lat = in.readString();
        lng = in.readString();
        icon = in.readString();
        id = in.readString();
        open_now = in.readString();
        rating = in.readString();
        reference = in.readString();
        author_name = in.readString();
        author_url = in.readString();
        text = in.readString();
        website = in.readString();
    }

    public static final Creator<PlaceDetailInfo> CREATOR = new Creator<PlaceDetailInfo>() {
        @Override
        public PlaceDetailInfo createFromParcel(Parcel in) {
            return new PlaceDetailInfo(in);
        }

        @Override
        public PlaceDetailInfo[] newArray(int size) {
            return new PlaceDetailInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getFormatted_phone_number() {
        return formatted_phone_number;
    }

    public void setFormatted_phone_number(String formatted_phone_number) {
        this.formatted_phone_number = formatted_phone_number;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpen_now() {
        return open_now;
    }

    public void setOpen_now(String open_now) {
        this.open_now = open_now;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(formatted_address);
        dest.writeString(formatted_phone_number);
        dest.writeString(lat);
        dest.writeString(lng);
        dest.writeString(icon);
        dest.writeString(id);
        dest.writeString(open_now);
        dest.writeString(rating);
        dest.writeString(reference);
        dest.writeString(author_name);
        dest.writeString(author_url);
        dest.writeString(text);
        dest.writeString(website);
    }
}
