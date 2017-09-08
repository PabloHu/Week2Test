package com.example.admin.week2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    private static final String TAG = "MainTAG";
    TestAsyncTask testAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        /*
        Coding test:
        1. Create an application that generates a random number
        and updates the textview with that number.
        The random number generation will be done in a separate thread.
        You cannot pass the textview to the thread.
        2. Create a Java function to add the odd numbers in the “List” of numbers.
        Input: List<Integer> Numbers = new ArrayList<>;
        Numbers.add(13);
        Numbers.add(5);
        Numbers.add(14);

        Output: 18
        Have atleast 20 numbers in the list, you can use the random generator to initialize the list
        3. Write a Singleton class. Make it thread safe.
        4. Write a function that validates an email.
    */

        Question1();
        Question2();
        Question3();
        Question4();

    }

    private void Question4() {

validateEmail("Ki@gmail.com");

    }

    private void validateEmail(String email) {

        String check = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(check);


            Matcher matcher = pattern.matcher(email);
        Log.d(TAG, "validateEmail: "+ matcher.matches());


    }


    private void Question3() {
        ASingleton aSingleton = new ASingleton();

    }

    private void Question2() {
        // Create a Java function to add the odd numbers in the “List” of numbers.
        List<Integer> numbers = new ArrayList<Integer>();

        //int a = createRandonNumber();
        for (int i = 0; i < 20; i++) {


            numbers.add(createRandonNumber());
        }
        int additionOddNum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i) % 2) != 0) {
                additionOddNum += numbers.get(i);
            }
        }


        Log.d(TAG, "Question2 sum: " + additionOddNum);

    }

    private void Question1() {

        testAsyncTask = new TestAsyncTask();

        testAsyncTask.execute();
        int a = testAsyncTask.onPostExecute();
        Log.d(TAG, "Question1: " + a);
        tvDisplay.setText(Integer.toString(a));
    }

    private int createRandonNumber() {


        Random rand = new Random();
        int n = rand.nextInt(50) + 1;
        return n;
    }


}
