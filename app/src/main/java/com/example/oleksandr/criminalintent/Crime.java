package com.example.oleksandr.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Oleksandr on 23.11.2016.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        //Генерація угікального id
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() { return mDate; }

    public boolean isSolved() {
        return mSolved;
    }

    public void setDate(Date date) { mDate = date;}

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
