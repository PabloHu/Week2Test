package com.example.admin.week2test;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Admin on 9/8/2017.
 */

public class TestAsyncTask  extends AsyncTask<Integer, Integer, Integer>{

    int randNum=0;

    public TestAsyncTask() {

    }

    public static final String TAG = "AsyncTaskTag";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: ");
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        Random rand = new Random();
        int n = rand.nextInt(50) + 1;



        randNum = n;
        Log.d(TAG, "doInBackground: " + n);
        onPostExecute();
        return n;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: "+ values[0]+Thread.currentThread());
    }


    protected int onPostExecute() {

        Log.d(TAG, "onPostExecute: "+randNum);
        return randNum;
    }
}
