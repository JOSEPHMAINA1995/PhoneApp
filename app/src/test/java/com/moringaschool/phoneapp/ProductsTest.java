package com.moringaschool.phoneapp;

import static org.junit.Assert.assertEquals;

import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ProductsTest {
    private Products products;

    @Before
    public void setUp(){
        products = Robolectric.buildActivity(Products.class)
                .create()
                .start()
                .resume()
                .get();

    }
    @Test
    public  void userInput(){
        TextInputLayout textInputLayout = products.findViewById(R.id.editTextTextPersonName);
        assertEquals("name", textInputLayout.getEditText().getHint());

    }
    @Test
    public void validateButton(){
        Button button = products.findViewById(R.id.contactUs);
        assertEquals("contactUs", button.getId());

    }
}
