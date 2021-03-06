package com.moringaschool.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.submitButton)
    Button mButton;
    @BindView(R.id.textInputEditText)
    TextInputLayout mtextInputEditText;

    boolean isAllFieldsChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String name = mtextInputEditText.getEditText().getText().toString();

                //validating the user input
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Intent intent = new Intent(MainActivity.this, Products.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

            }
        });
    }

    private boolean CheckAllFields() {
        if (mtextInputEditText.getEditText().length() == 0) {
            mtextInputEditText.setError("This field is required");
            return false;
        }
        return true;
    }


}
