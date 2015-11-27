package com.natallia.lesson7_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Administrator on 26.11.15.
 */
public class MyDialogFragment extends DialogFragment{
    public static final int ID_TEXTVIEW_1 = 1;
    public static final int ID_TEXTVIEW_2 = 2;
    public static final int ID_TEXTVIEW_3 = 3;
    public static ArrayList mSelectedItems;

    public Activity activity;


    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction





        mSelectedItems = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.dialog_message)

                .setMultiChoiceItems(R.array.Days, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                 if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })

                .setPositiveButton(R.string.dialog_select, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         mListener.onDialogPositiveClick(MyDialogFragment.this);



                        }


                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }



}
