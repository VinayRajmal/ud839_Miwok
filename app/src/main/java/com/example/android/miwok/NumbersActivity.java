/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an array of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("one", "ek"));
        words.add(new Word("two", "do"));
        words.add(new Word("three", "teen"));
        words.add(new Word("four", "Chaar"));
        words.add(new Word("five", "paanch"));
        words.add(new Word("six", "Chey"));

        // Verify the contents of the array by printing out each array element to the logs
        Log.v("NumbersActivity", "Word at index 0: " + words.get(0));
        Log.v("NumbersActivity", "Word at index 1: " + words.get(1));


        ListView rootView = (ListView) findViewById(R.id.numbersRoot);
        /*
        // Linear layout uses too much memory, and it is better to use ListView and ArrayAdapter to save memory
        for (String word:words) {

            TextView tempTextView = new TextView(this);
            tempTextView.setText(word);
            rootView.addView(tempTextView);
        }*/

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        rootView.setAdapter(itemsAdapter);
    }
}
