package com.example.mdowlin.converta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;


public class FragTemp extends Fragment implements Button.OnClickListener{


    int lastEdited=0;
    EditText editFah, editCel;
    Button convBtn;


    public FragTemp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_frag_temp, container, false);

        editCel = myView.findViewById(R.id.editCel);
        editCel.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        //doing nothing.
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // do nothing here.
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        lastEdited = 1;
                    }
                }
        );

        editFah = myView.findViewById(R.id.editFah);
        editFah.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        //doing nothing.
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // do nothing here.
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        lastEdited = 0;
                    }
                }
        );

        convBtn = myView.findViewById(R.id.convBtn);
        convBtn.setOnClickListener(this);

        return myView;
    }

    public void onClick(View v)
    {
        //F to C
        if(lastEdited == 0)
        {
            String tempStr = editFah.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double tempNow = Double.parseDouble(tempStr);
            tempNow = (tempNow - 32) * 5 / 9;
            String calced = String.format("%.2f",tempNow);
            editCel.setText(calced);
            lastEdited = 0;
        }
        //C to F
        else
        {
            String tempStr = editCel.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double tempNow = Double.parseDouble(tempStr);
            tempNow = tempNow * 9 / 5 + 32;
            String calced = String.format("%.2f",tempNow);
            editFah.setText(calced);
            lastEdited = 1;
        }
    }

}
