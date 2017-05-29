package com.example.rechee.smsmanage.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.example.rechee.smsmanage.R;

import java.util.ArrayList;

/**
 * Created by Rechee on 5/29/2017.
 */

public class ErrorDialogFragment extends DialogFragment {
    private String errorTitle;
    private String errorMessage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        super.onCreateDialog(savedInstanceState);

        if(savedInstanceState == null){
            this.errorTitle = getString(R.string.invalid_operation);
            this.errorTitle = getString(R.string.error);
        }
        else{
            ArrayList<String> errorDetails = savedInstanceState.getStringArrayList("errorDetails");

            if(errorDetails == null){
                this.errorTitle = getString(R.string.invalid_operation);
                this.errorTitle = getString(R.string.error);
            }
            else{
                this.errorTitle = errorDetails.get(0);
                this.errorMessage = errorDetails.get(1);
            }
        }

        return new AlertDialog.Builder(getActivity())
                .setTitle(this.errorTitle)
                .setMessage(this.errorMessage)
                .create();
    }

    public static ErrorDialogFragment getErrorDialog(String errorTitle, String errorMessage){
        Bundle dialogBundle = new Bundle(1);

        ArrayList<String> errorDetails = new ArrayList<>(2);
        errorDetails.add(errorTitle);
        errorDetails.add(errorMessage);

        dialogBundle.putStringArrayList("errorDetails", errorDetails);

        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        errorDialogFragment.setArguments(dialogBundle);
        return errorDialogFragment;
    }

    public static ErrorDialogFragment getErrorDialog(int errorTitleResourceID, int errorMessageResourceID, Context context){
        return getErrorDialog(context.getString(errorTitleResourceID), context.getString(errorMessageResourceID));
    }
}
