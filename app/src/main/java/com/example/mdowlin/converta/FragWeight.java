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


public class FragWeight extends Fragment implements Button.OnClickListener{


    int lastEdited=0;
    EditText editPound, editKg;
    Button convBtn;


    public FragWeight() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_frag_weight, container, false);

        editKg = myView.findViewById(R.id.editKg);
        editKg.addTextChangedListener(
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

        editPound = myView.findViewById(R.id.editPound);
        editPound.addTextChangedListener(
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

        convBtn = myView.findViewById(R.id.convWeight);

        convBtn.setOnClickListener(this);

        return myView;
    }

    public void onClick(View v)
    {
        //Pound to Kg
        if(lastEdited == 0)
        {
            String tempStr = editPound.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double weightNow = Double.parseDouble(tempStr);
            weightNow = weightNow * 0.453592;
            String calced = String.format("%.2f",weightNow);
            editKg.setText(calced);
            lastEdited = 0;
        }
        //Kg to Pound
        else
        {
            String tempStr = editKg.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double weightNow = Double.parseDouble(tempStr);
            weightNow = weightNow * 2.20462;
            String calced = String.format("%.2f",weightNow);
            editPound.setText(calced);
            lastEdited = 1;
        }
    }

}
