package com.example.phone_store_app.models;

public class PhoneInfo {

    //Initialising variables to be used as getters
    private String mName, mColour, mScreenSize, mMem, mStorage,
        mCam, mDataCon, mPrice, mBattery;

    private int mID, mImage;
    private int[] mImageArray;

    public PhoneInfo(int ID, String name, String price, String colour, String battery ,String ScreenSize,
                     String Memory, String Storage, String Camera, String DataCon, int image,
                     int[] imageArray) {
        mID = ID;
        mName = name;
        mPrice = price;
        mColour = colour;
        mBattery = battery;
        mScreenSize = ScreenSize;
        mMem = Memory;
        mStorage = Storage;
        mCam = Camera;
        mDataCon = DataCon;
        mImage = image;
        mImageArray = imageArray;
    }


    //Getters for phone information
    public int getID() {
        return mID;
    }

    public String getName(){
        return mName;
    }

    public String getColour(){
        return mColour;
    }

    public String getBattery(){
        return mBattery;
    }

    public String getScreenSize(){
        return mScreenSize;
    }

    public String getMemory(){
        return mMem;
    }

    public String getStorage(){
        return mStorage;
    }

    public String getCamera(){
        return mCam;
    }

    public String getDataCon(){
        return mDataCon;
    }

    public String getPrice(){
        return mPrice;
    }

    public int getImage() {
        return mImage;
    }

    public int[] getImageArray(){
        return mImageArray;
    }

}
