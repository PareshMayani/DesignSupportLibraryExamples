package com.technotalkative.textinputlayoutdemo;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validateInput();
    }

    private void validateInput() {

        final TextInputLayout layoutFirstName = (TextInputLayout) findViewById(R.id.layoutFirstName);
        layoutFirstName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 6) {
                    layoutFirstName.setError("Input required");
                    layoutFirstName.setErrorEnabled(true);
                } else {
                    layoutFirstName.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }

    public void btnValidateInputClick(View view) {

        final TextInputLayout layoutLastName = (TextInputLayout) findViewById(R.id.layoutLastName);
        String strLastName = layoutLastName.getEditText().getText().toString();

        if(!TextUtils.isEmpty(strLastName)) {
            Snackbar.make(view, strLastName, Snackbar.LENGTH_SHORT).show();
            layoutLastName.setErrorEnabled(false);
        } else {
            layoutLastName.setError("Input required");
            layoutLastName.setErrorEnabled(true);
        }
    }

    public void btnValidateDialogInputClick(View v) {
        FeedbackFragment fragment = new FeedbackFragment();
        fragment.show(getSupportFragmentManager(),"FeedbackFragment");
    }
}
