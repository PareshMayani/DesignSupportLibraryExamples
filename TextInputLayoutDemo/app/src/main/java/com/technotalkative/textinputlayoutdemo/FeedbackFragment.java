package com.technotalkative.textinputlayoutdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by paresh.mayani on 25-07-2015.
 */
public class FeedbackFragment extends DialogFragment {

    private TextInputLayout mLayoutMessage;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View feedbackView = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_feedback, (ViewGroup) getView(), false);

        mLayoutMessage = (TextInputLayout) feedbackView.findViewById(R.id.layoutMessage);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(feedbackView)
                .setTitle("Feedback")
                .setCancelable(true)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Send",null);

        return builder.create();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        final AlertDialog d = (AlertDialog) getDialog();
        if(d != null)
        {
            Button positiveButton = (Button) d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if(validateInputs())
                        d.dismiss();
                }
            });
        }
    }

    private boolean validateInputs() {

        boolean isValidInput = false;
        String strLastName = mLayoutMessage.getEditText().getText().toString();

        if(!TextUtils.isEmpty(strLastName)) {
            mLayoutMessage.setErrorEnabled(false);
            isValidInput = true;
        } else {
            mLayoutMessage.setError("Input required");
            mLayoutMessage.setErrorEnabled(true);
            isValidInput = false;
        }

        return isValidInput;
    }
}
