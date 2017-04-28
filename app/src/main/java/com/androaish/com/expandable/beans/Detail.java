package com.androaish.com.expandable.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aishwarya on 11/23/2016.
 */
//Sub-list which is to be shown when expanded --------childlist
public class Detail implements Parcelable {

    private String apilevel;
    private String version;

    protected Detail(Parcel in) {
        apilevel = in.readString();
        version = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(apilevel);
        dest.writeString(version);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };

    /**
     * @return The apilevel
     */
    public String getApilevel() {
        return apilevel;
    }

    /**
     * @param apilevel The apilevel
     */
    public void setApilevel(String apilevel) {
        this.apilevel = apilevel;
    }

    /**
     * @return The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version The version
     */
    public void setVersion(String version) {
        this.version = version;
    }


}
