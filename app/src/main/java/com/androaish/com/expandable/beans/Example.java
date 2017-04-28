package com.androaish.com.expandable.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.androaish.com.expandable.Model.MainListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aishwarya on 11/23/2016.
 */

//Main List which contains a sub-list inside --------Parentlist
public class Example implements Parcelable,MainListItem {


        private String codename;

        private List<Detail> details = new ArrayList<Detail>();

    protected Example(Parcel in) {
        codename = in.readString();
        details = in.createTypedArrayList(Detail.CREATOR);
    }

    public static final Creator<Example> CREATOR = new Creator<Example>() {
        @Override
        public Example createFromParcel(Parcel in) {
            return new Example(in);
        }

        @Override
        public Example[] newArray(int size) {
            return new Example[size];
        }
    };

    /**
         *
         * @return
         * The codename
         */
        public String getCodename() {
            return codename;
        }

        /**
         *
         * @param codename
         * The codename
         */
        public void setCodename(String codename) {
            this.codename = codename;
        }

        /**
         *
         * @return
         * The details
         */
        public List<Detail> getDetails() {
            return details;
        }

        /**
         *
         * @param details
         * The details
         */
        public void setDetails(List<Detail> details) {
            this.details = details;
        }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codename);
        dest.writeTypedList(details);
    }

    @Override
    public List<?> getChildItemList() {
        return details;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
