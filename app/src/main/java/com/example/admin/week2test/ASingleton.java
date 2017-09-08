package com.example.admin.week2test;

/**
 * Created by Admin on 9/8/2017.
 */

public class ASingleton  {
    private static ASingleton instance = null;

    public ASingleton() {
    }

    public static ASingleton getInstance() {
        if (instance == null) {
            instance = new ASingleton();
        }
        return instance;
    }
}
