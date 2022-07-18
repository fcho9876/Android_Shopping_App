package com.example.phone_store_app.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.phone_store_app.R;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class DataProvider {

    // ID's for each item in each category
    // For testing purposes add 6 items are added to Samsung category
    private static int[] IDSamsung = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] appleID = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    private static int[] xiaomiID = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

    private static int[] allID = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                                        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

    // Prices for each item in each category
    private static String[] priceSamsung = {"$1029.99", "$1999.99", "$349.99", "$199.99", "$599.99", "$949.99",
                                                "$749.99", "$299.99", "$499.99", "$849.99"};
    private static String[] priceApple = {"$824.99", "$1099.99", "$1249.99", "$989.99", "$1769.99", "$1429.99",
                                                "$1449.99", "$1799.99", "$1999.99", "$799.99"};
    private static String[] priceXiaomi = {"$349.99", "$529.99", "$579.99", "$599.99", "$949.99", "$1579,99",
                                                "$949.99", "$1179.99", "$599.99", "$639.99"};

    // Name of each item in each category
    private static String[] nameSamsung = {"Samsung S20 Ultra", "Samsung S22 Ultra", "Samsung M22", "Samsung A03", "Samsung A52", "Samsung S21 FE",
                                                "Samsung S10 Plus", "Samsung S8 Plus", "Samsung A23", "Samsung A73"};
    private static String[] nameApple = {"iPhone 11", "iPhone 11 Pro Max", "iPhone 12", "iPhone 12 Mini", "iPhone 12 Pro Max", "iPhone 13",
                                                "iPhone 13 Mini", "iPhone 13 Pro", "iPhone 13 Pro Max", "iPhone SE"};
    private static String[] nameXiaomi = {"Xiaomi Redmi 10", "Xiaomi Redmi 10 Pro", "Xiaomi Mi 11 Lite", "Xiaomi Redmi Note 11 Pro",
                                                "Xiaomi Mi 12", "Xiaomi 12 pro", "Xiaomi Mi 12X", "Xiaomi Poco F4 GT", "Xiaomi Poco X3 Pro", "Xiaomi X4 Pro"};


    // Colour of each item in each category
    private static String[] colourSamsung = {"Cosmic Grey", "Burgundy", "Blue", "Black", "Black", "Black",
                                                "Prism Blue", "Arctic Silver", "Black", "White"};
    private static String[] colourApple = {"Purple", "Silver", "Black", "Purple", "Pacific Blue", "Starlight",
                                                "Pink", "Graphite", "Alpine Green", "Red"};
    private static String[] colourXiaomi = {"Sea Blue", "Grey", "Mint Green", "Atlantic Blue", "Purple", "Blue",
                                                "Grey", "Stealth Black", "Metal Bronze", "Lazer Black"};

    //Battery size of each item
    static String[] batterySamsung = {"5000 mAh", "5000 mAh", "5000 mAh", "5000 mAh", "4500 mAh",
                                        "4500 mAh", "4100 mAh", "3500 mAh", "5000 mAh", "5000 mAh"};
    static String[] batteryApple = {"3110 mAh", "3969 mAh", "2815 mAh", "2227 mAh", "3687 mAh",
                                        "3240 mAh", "2438 mAh", "6000 mAh", "4352 mAh", "2018 mAh"};
    static String[] batteryXiaomi = {"5000 mAh", "5000 mAh", "4250 mAh", "4000 mAh", "4500 mAh",
                                        "5000 mAh", "5000 mAh", "5000 mAh", "5000 mAh", "5000 mAh"};

    // Screen size of each item in each category
    private static String[] screenSizeSamsung = {"6.9 inches", "6.8 inches", "6.4 inches", "6.5 inches", "6.5 inches", "6.4 inches",
                                                    "6.4 inches", "6.2 inches", "6.6 inches", "6.7 inches"};
    private static String[] screenSizeApple = {"6.1 inches", "6.5 inches", "6.1 inches" ,"5.4 inches", "6.7 inches", "6.1 inches",
                                                    "5.4 inches", "6.1 inches", "6.7 inches", "4.7 inches"};
    private static String[] screenSizeXiaomi = {"6.5 inches", "6.7 inches", "6.6 inches", "6.7 inches", "6.3 inches", "6.7 inches",
                                                    "6.3 inches", "6.7 inches", "6.7 inches", "6.7 inches"};

    // Memory of each item in each category
    private static String[] memorySamsung = {"16 GB", "16 GB", "8 GB", "8 GB", "16 GB", "12 GB", "16 GB",
                                                "8 GB", "16 GB", "12 GB"};
    private static String[] memoryApple = {"16 GB", "24 GB", "12 GB", "16 GB", "16 GB", "32 GB", "16 GB",
                                                "32 GB", "32 GB", "8 GB"};
    private static String[] memoryXiaomi = {"16 GB", "8 GB", "16 GB", "8 GB", "8 GB", "16 GB", "16 GB", "8 GB",
                                                "16 GB", "8 GB"};

    // Storage of each item in each category
    private static String[] storageSamsung = {"256 GB", "256 GB", "64 GB", "64 GB", "64 GB", "64 GB", "128 GB",
                                                "256 GB", "128 GB", "64 GB"};
    private static String[] storageApple = {"256 GB", "512 GB", "512 GB", "256 GB", "128 GB", "256 GB",
                                                "512 GB", "512 GB", "512 GB", "64 GB"};
    private static String[] storageXiaomi = {"256 GB", "128 GB", "128 GB", "512 GB", "256 GB", "256 GB", "128 GB",
                                                "256 GB", "128 GB", "128 GB"};

    // Data connectivity of each item in each category
    private static String[] dataConSamsung = {"5G", "5G", "5G", "5G", "5G", "5G", "5G", "5G", "5G", "5G"};
    private static String[] dataConApple = {"5G", "5G", "5G", "5G", "5G", "5G", "5G", "5G", "5G", "5G"};
    private static String[] dataConXiaomi = {"4G", "4G", "4G", "4G", "4G", "4G", "4G", "4G", "4G", "4G"};

    // Camera of each item in each category
    static String[] cameraSamsung = {"108 MP", "108 MP", "48 MP", "48 MP", "64 MP", "12 MP",
                                        "16 MP", "12 MP", "50 MP", "108 MP"};
    static String[] cameraApple = {"12 MP", "12 MP", "12 MP", "12 MP", "12 MP", "12 MP",
                                        "12 MP", "12 MP", "12 MP", "12 MP"};
    static String[] cameraXiaomi = {"50 MP", "108 MP", "64 MP", "108 MP", "50 MP", "50 MP",
                                        "50 MP", "64 MP", "48 MP", "50 MP"};

    // Image of each item in each category
    private static int imagesSamsung[] = {R.drawable.ss20u, R.drawable.samsung_category_logo, R.drawable.samsung_m22, R.drawable.samsung_a03,
            R.drawable.samsung_a52, R.drawable.samsung_s21fe, R.drawable.s10p, R.drawable.s8p, R.drawable.sa23, R.drawable.sa73};

    private static int imagesApple[] = {R.drawable.i11one, R.drawable.i11pm1, R.drawable.i12one,
                                        R.drawable.i12mini1, R.drawable.i12pm1, R.drawable.i13one,
                                        R.drawable.i13mini1, R.drawable.i13p1, R.drawable.i13pm1, R.drawable.ise1};

    private static int imagesXiamoi[] = {R.drawable.x10one, R.drawable.x10p1, R.drawable.x11l1, R.drawable.x11p1,
                                         R.drawable.x12one, R.drawable.x12p1, R.drawable.x12x1, R.drawable.xf4one,
                                         R.drawable.xx3p1, R.drawable.xx4p1};

    private static int image_all_array[] = {R.drawable.ss20u, R.drawable.samsung_category_logo, R.drawable.samsung_m22, R.drawable.samsung_a03,
            R.drawable.samsung_a52, R.drawable.samsung_s21fe, R.drawable.s10p, R.drawable.s8p, R.drawable.sa23, R.drawable.sa73, R.drawable.i11one, R.drawable.i11pm1, R.drawable.i12one,
            R.drawable.i12mini1, R.drawable.i12pm1, R.drawable.i13one, R.drawable.i13mini1, R.drawable.i13p1, R.drawable.i13pm1, R.drawable.ise1, R.drawable.x10one, R.drawable.x10p1, R.drawable.x11l1, R.drawable.x11p1, R.drawable.x12one, R.drawable.x12p1, R.drawable.x12x1, R.drawable.xf4one,
            R.drawable.xx3p1, R.drawable.xx4p1};

    private static int slideshowSamImages[] = {R.drawable.ss20u, R.drawable.ss20u2, R.drawable.ss20u3, R.drawable.samsung_category_logo,
    R.drawable.ss22u2, R.drawable.ss22u3, R.drawable.samsung_m22, R.drawable.sm22two, R.drawable.sm22three,
    R.drawable.samsung_a03, R.drawable.sa03two, R.drawable.sa03three, R.drawable.samsung_a52, R.drawable.sa52two,
    R.drawable.sa52three, R.drawable.samsung_s21fe, R.drawable.s21fe2, R.drawable.s21fe3, R.drawable.s10p,
    R.drawable.s10p2, R.drawable.s10p3, R.drawable.s8p, R.drawable.s8p1, R.drawable.s8p2, R.drawable.sa23,
    R.drawable.sa23two, R.drawable.sa23three, R.drawable.sa73, R.drawable.sa73two, R.drawable.sa73three};

    private static int slideshowAppleImages[] = {R.drawable.i11one, R.drawable.i11two, R.drawable.i11three,
    R.drawable.i11pm1, R.drawable.i11pm2, R.drawable.i11pm3, R.drawable.i12one, R.drawable.i12two,
    R.drawable.i12three, R.drawable.i12mini1, R.drawable.i12mini2, R.drawable.i12mini3, R.drawable.i12pm1,
    R.drawable.i12pm2, R.drawable.i12pm3, R.drawable.i13one, R.drawable.i13two, R.drawable.i13three,
    R.drawable.i13mini1, R.drawable.i13mini2, R.drawable.i13mini3, R.drawable.i13p1, R.drawable.i13p2,
    R.drawable.i13p3, R.drawable.i13pm1, R.drawable.i13pm2, R.drawable.i13pm3, R.drawable.ise1,
    R.drawable.ise2, R.drawable.ise3};

    private static int slideshowXiamoiImages[] = {R.drawable.x10one, R.drawable.x10two, R.drawable.x10three,
    R.drawable.x10p1, R.drawable.x10p2, R.drawable.x10p3, R.drawable.x11l1, R.drawable.x11l2, R.drawable.x11l3,
    R.drawable.x11p1, R.drawable.x11p2, R.drawable.x11p3, R.drawable.x12one, R.drawable.x12two,
    R.drawable.x12three, R.drawable.x12p1, R.drawable.x12p2, R.drawable.x12p3, R.drawable.x12x1,
    R.drawable.x12x2, R.drawable.x12x3, R.drawable.xf4one, R.drawable.xf4two, R.drawable.xf4three,
    R.drawable.xx3p1, R.drawable.xx3p2, R.drawable.xx3p3, R.drawable.xx4p1, R.drawable.xx4p2,
    R.drawable.xx4p3};

    private static int mostPopImages[] ={R.drawable.ss20u, R.drawable.samsung_category_logo, R.drawable.samsung_m22, R.drawable.samsung_a03,
            R.drawable.samsung_a52, R.drawable.samsung_s21fe, R.drawable.s10p, R.drawable.s8p, R.drawable.sa23, R.drawable.sa73,
            R.drawable.i11one, R.drawable.i11pm1, R.drawable.i12one,
            R.drawable.i12mini1, R.drawable.i12pm1, R.drawable.i13one,
            R.drawable.i13mini1, R.drawable.i13p1, R.drawable.i13pm1, R.drawable.ise1,
            R.drawable.x10one, R.drawable.x10p1, R.drawable.x11l1, R.drawable.x11p1,
            R.drawable.x12one, R.drawable.x12p1, R.drawable.x12x1, R.drawable.xf4one,
            R.drawable.xx3p1, R.drawable.xx4p1};

    // Function to generate data for Samsung category items
    public static ArrayList<PhoneInfo> generateSamsungData() {
        ArrayList<PhoneInfo> SamsungPhones = new ArrayList<PhoneInfo>();
        for (int i : IDSamsung) {
            int ID = IDSamsung[i];
            String name = nameSamsung[i];
            String price = priceSamsung[i];
            String colour = colourSamsung[i];
            String Battery = batterySamsung[i];
            String ScreenSize = screenSizeSamsung[i];
            String Memory = memorySamsung[i];
            String Storage = storageSamsung[i];
            String Camera = cameraSamsung[i];
            String DataCon = dataConSamsung[i];

            int image = imagesSamsung[i];

            int imageArray[] = {0,0,0};


            int j1 = i*3;
            int j2 = (i*3) + 1;
            int j3 = (i*3) + 2;
            if(i == 0){
                imageArray[0] = slideshowSamImages[0];
                imageArray[1] = slideshowSamImages[1];
                imageArray[2] = slideshowSamImages[2];
            }
            else{
                imageArray[0] = slideshowSamImages[j1];
                imageArray[1] = slideshowSamImages[j2];
                imageArray[2] = slideshowSamImages[j3];
            }


            PhoneInfo mPhone = new PhoneInfo(ID, name, price, colour, Battery,ScreenSize, Memory,
                                                Storage, Camera, DataCon, image, imageArray);
            SamsungPhones.add(mPhone);
        }

        return SamsungPhones;
    }

    // Function to generate data for Apple category items
    public static ArrayList<PhoneInfo> generateAppleData() {
        ArrayList<PhoneInfo> ApplePhones = new ArrayList<PhoneInfo>();
        for (int i = 0; i < appleID.length; i++) {
            int ID = appleID[i];
            String name = nameApple[i];
            String price = priceApple[i];
            String colour = colourApple[i];
            String Battery = batteryApple[i];
            String ScreenSize = screenSizeApple[i];
            String Memory = memoryApple[i];
            String Storage = storageApple[i];
            String Camera = cameraApple[i];
            String DataCon = dataConApple[i];

            int image = imagesApple[i];

            int imageArray[] = {0,0,0};
            int j1, j2, j3;
            j1 = i*3;
            j2 = (i*3) + 1;
            j3 = (i*3) + 2;
            if(i == 0){
                imageArray[0] = slideshowAppleImages[0];
                imageArray[1] = slideshowAppleImages[1];
                imageArray[2] = slideshowAppleImages[2];
            }
            else{
                imageArray[0] = slideshowAppleImages[j1];
                imageArray[1] = slideshowAppleImages[j2];
                imageArray[2] = slideshowAppleImages[j3];
            }

            PhoneInfo mPhone = new PhoneInfo(ID, name, price, colour, Battery,ScreenSize, Memory,
                    Storage, Camera, DataCon, image, imageArray);
            ApplePhones.add(mPhone);
        }

        return ApplePhones;
    }


    // Function to generate data for Xiaomi category items
    public static ArrayList<PhoneInfo> generateXiaomiData() {
        ArrayList<PhoneInfo> XiaomiPhones = new ArrayList<PhoneInfo>();
        for (int i = 0; i < xiaomiID.length; i++) {
            int ID = xiaomiID[i];
            String name = nameXiaomi[i];
            String price = priceXiaomi[i];
            String colour = colourXiaomi[i];
            String Battery = batteryXiaomi[i];
            String ScreenSize = screenSizeXiaomi[i];
            String Memory = memoryXiaomi[i];
            String Storage = storageXiaomi[i];
            String Camera = cameraXiaomi[i];
            String DataCon = dataConXiaomi[i];

            int image = imagesXiamoi[i];

            int imageArray[] = {0,0,0};
            int j1, j2, j3;
            j1 = i*3;
            j2 = (i*3) + 1;
            j3 = (i*3) + 2;
            if(i == 0){
                imageArray[0] = slideshowXiamoiImages[0];
                imageArray[1] = slideshowXiamoiImages[1];
                imageArray[2] = slideshowXiamoiImages[2];
            }
            else{
                imageArray[0] = slideshowXiamoiImages[j1];
                imageArray[1] = slideshowXiamoiImages[j2];
                imageArray[2] = slideshowXiamoiImages[j3];
            }

            PhoneInfo mPhone = new PhoneInfo(ID, name, price, colour, Battery,ScreenSize, Memory,
                    Storage, Camera, DataCon, image, imageArray);
            XiaomiPhones.add(mPhone);
        }

        return XiaomiPhones;
    }

    // Function to generate random data for 'Most Popular' section in home page
    public static int[] generateRandomPhone(int[] id) {
        Random rand = new Random();
        int[] ran_image_array = new int[]{0,0,0,0};
        for(int i = 0; i < 4; i++) {
            // Generate random number between 0 and 90
            int n = rand.nextInt(30);
            ran_image_array[i] = mostPopImages[n];
            id[i] = allID[n];
        }
        return ran_image_array;
    }

    //Method to add all the phones to one ArrayList
    public static ArrayList<PhoneInfo> generateAllPhones(ArrayList<PhoneInfo> samPhone,
                                                         ArrayList<PhoneInfo> applePhone,
                                                         ArrayList<PhoneInfo> xiaomiPhone){
        ArrayList<PhoneInfo> allPhones = new ArrayList<PhoneInfo>();

        for (int i = 0; i < samPhone.size(); i++) {
            allPhones.add(samPhone.get(i));
        }
        for (int j = 0; j < applePhone.size(); j++) {
            allPhones.add(applePhone.get(j));
        }
        for (int z = 0; z < 10; z++){
            allPhones.add(xiaomiPhone.get(z));
        }
        return allPhones;
    }

    // Function to generate random data for 'Most Popular' section in home page
    // input array should be the top 4 pick ID's
    public static int[] generateTopFour(int[] input_array) {
        // output array
        int[] image_output_array = new int[]{0, 0, 0, 0};
        for(int i = 0; i < 4; i++) {
            image_output_array[i] = image_all_array[input_array[i]];
        }
        return image_output_array;
    }


    // method to find the top 4 most clicked items
    public static int[] getTopFour(Context mContext) {
        SharedPreferences preferences = mContext.getSharedPreferences("click_count", Context.MODE_PRIVATE);
        Map<String, ?> allEntries = preferences.getAll();

        // initialize with fixed values
        int maxKey_1 = 2;
        int maxKey_2 = 8;
        int maxKey_3 = 12;
        int maxKey_4 = 24;

        int first, second, third, fourth;
        fourth = third = second = first = Integer.MIN_VALUE;
        // iterate through the saved preferences to find the key value with highest click count
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            int key = Integer.valueOf(entry.getKey());
            int value = Integer.valueOf(entry.getValue().toString());

            if (value > first) {
               //max = value;
               maxKey_1 = key;
                fourth = third;
                third = second;
                second = first;
                first = value;
            } else if (value > second) {
                maxKey_2 = key;
                fourth = third;
                third = second;
                second = value;
            } else if (value > third) {
                maxKey_3 = key;
                fourth = third;
                third = value;
            } else if (value > fourth) {
                maxKey_4 = key;
                fourth = value;
            }

        }
        // for testing
        // Log.d("Top 4 picks are", String.valueOf(maxKey_1) + " and " + String.valueOf(maxKey_2) + " and " + String.valueOf(maxKey_3) + " and " + String.valueOf(maxKey_4));
        int top_4_array[] = {maxKey_1, maxKey_2, maxKey_3, maxKey_4};
        return top_4_array;
    }

    
    // methods to count number of clicks on items
    // reset count at every app launch
    public static void resetClick(Context mContext, SharedPreferences preferences) {
        preferences.edit().clear().commit();
    }

    public static void addClick(Context mContext, int ID) {
        // increment each different item click by 1
        int click = getClicksCount(mContext, ID) + 1;
        SharedPreferences preferences = mContext.getSharedPreferences("click_count", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // insert corresponding click value to ID key
        editor.putInt(String.valueOf(ID), click);
        editor.apply();
    }

    public static int getClicksCount(Context mContext, int ID){
        SharedPreferences preferences = mContext.getSharedPreferences("click_count",Context.MODE_PRIVATE);
        return preferences.getInt(String.valueOf(ID),0);
    }

}