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


public class FragLength extends Fragment implements Button.OnClickListener{


    int lastEdited=0;
    EditText editIn, editFt, editM, editCm, editm, editKm;
    Button convBtn;


    public FragLength() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_frag_length, container, false);

        editFt = myView.findViewById(R.id.editFt);
        editFt.addTextChangedListener(
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

        editM = myView.findViewById(R.id.editM);
        editM.addTextChangedListener(
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

        editCm = myView.findViewById(R.id.editCm);
        editCm.addTextChangedListener(
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
                        lastEdited = 2;
                    }
                }
        );

        editm = myView.findViewById(R.id.editm);
        editm.addTextChangedListener(
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
                        lastEdited = 3;
                    }
                }
        );

        editKm = myView.findViewById(R.id.editKm);
        editKm.addTextChangedListener(
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
                        lastEdited = 4;
                    }
                }
        );

        editIn = myView.findViewById(R.id.editIn);
        editIn.addTextChangedListener(
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
                        lastEdited = 5;
                    }
                }
        );

        convBtn = myView.findViewById(R.id.convBtn2);
        convBtn.setOnClickListener(this);

        return myView;
    }

    public void onClick(View v)
    {
        //Feet
        if(lastEdited == 0)
        {
            String tempStr = editFt.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double lengthNow = Double.parseDouble(tempStr);

            double inchNow = lengthNow * 12;
            double milesNow = lengthNow * .000189394;
            double cmNow = lengthNow * 30.48;
            double mNow = lengthNow * .3048;
            double kmNow = lengthNow * .0003048;

            String inchStr = String.format("%.1f", inchNow);
            editIn.setText(inchStr);

            String mileStr = String.format("%.5f",milesNow);
            editM.setText(mileStr);

            String cmStr = String.format("%.2f",cmNow);
            editCm.setText(cmStr);

            String mStr = String.format("%.2f",mNow);
            editm.setText(mStr);

            String kmStr = String.format("%.5f",kmNow);
            editKm.setText(kmStr);
            lastEdited = 0;
        }
        //Miles
        else if (lastEdited == 1)
        {
            String tempStr = editM.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double lengthNow = Double.parseDouble(tempStr);

            double inchNow = lengthNow * 63360;
            double feetNow = lengthNow * 5280;
            double cmNow = lengthNow * 160934;
            double mNow = lengthNow * 1609.34;
            double kmNow = lengthNow * 1.60934;

            String inchStr = String.format("%.1f", inchNow);
            editIn.setText(inchStr);

            String feetStr = String.format("%.1f",feetNow);
            editFt.setText(feetStr);

            String cmStr = String.format("%.1f",cmNow);
            editCm.setText(cmStr);

            String mStr = String.format("%.1f",mNow);
            editm.setText(mStr);

            String kmStr = String.format("%.2f",kmNow);
            editKm.setText(kmStr);
            lastEdited = 1;
        }
        //Centimeters
        else if (lastEdited == 2)
        {
            String tempStr = editCm.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double lengthNow = Double.parseDouble(tempStr);

            double inchNow = lengthNow / 2.54;
            double feetNow = lengthNow * .0328084;
            double milesNow = lengthNow * .0000062137;
            double mNow = lengthNow * .01;
            double kmNow = lengthNow * .00001;

            String inchStr = String.format("%.1f", inchNow);
            editIn.setText(inchStr);

            String feetStr = String.format("%.3f",feetNow);
            editFt.setText(feetStr);

            String mileStr = String.format("%.6f",milesNow);
            editM.setText(mileStr);

            String mStr = String.format("%.2f",mNow);
            editm.setText(mStr);

            String kmStr = String.format("%.5f",kmNow);
            editKm.setText(kmStr);
            lastEdited = 2;
        }
        //Meters
        else if (lastEdited == 3)
        {
            String tempStr = editm.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double lengthNow = Double.parseDouble(tempStr);

            double inchNow = lengthNow * 39.3701;
            double feetNow = lengthNow * 3.28084;
            double milesNow = lengthNow * 0.000621371;
            double cmNow = lengthNow * 100;
            double kmNow = lengthNow * .001;

            String inchStr = String.format("%.1f", inchNow);
            editIn.setText(inchStr);

            String feetStr = String.format("%.2f",feetNow);
            editFt.setText(feetStr);

            String mileStr = String.format("%.5f",milesNow);
            editM.setText(mileStr);

            String cmStr = String.format("%.1f",cmNow);
            editCm.setText(cmStr);

            String kmStr = String.format("%.4f",kmNow);
            editKm.setText(kmStr);
            lastEdited = 3;
        }
        //Kilometers
        else if (lastEdited == 4)
        {
            String tempStr = editKm.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double lengthNow = Double.parseDouble(tempStr);

            double inchNow = lengthNow * 39370.079;
            double feetNow = lengthNow * 3280.84;
            double milesNow = lengthNow * 0.621371;
            double cmNow = lengthNow * 100000;
            double mNow = lengthNow * 1000;

            String inchStr = String.format("%.1f", inchNow);
            editIn.setText(inchStr);

            String feetStr = String.format("%.1f",feetNow);
            editFt.setText(feetStr);

            String mileStr = String.format("%.2f",milesNow);
            editM.setText(mileStr);

            String cmStr = String.format("%.1f",cmNow);
            editCm.setText(cmStr);

            String mStr = String.format("%.1f",mNow);
            editm.setText(mStr);
            lastEdited = 4;
        }
        //Inches
        else if (lastEdited == 5)
        {
            String tempStr = editIn.getText().toString();
            if(tempStr.equals("") || tempStr.equals("."))
                return;
            double lengthNow = Double.parseDouble(tempStr);

            double feetNow = lengthNow * .0833333;
            double milesNow = lengthNow / 63360;
            double cmNow = lengthNow * 2.54;
            double mNow = lengthNow * .0254;
            double kmNow = lengthNow * .0000254;

            String feetStr = String.format("%.2f",feetNow);
            editFt.setText(feetStr);

            String mileStr = String.format("%.6f",milesNow);
            editM.setText(mileStr);

            String cmStr = String.format("%.2f",cmNow);
            editCm.setText(cmStr);

            String mStr = String.format("%.3f",mNow);
            editm.setText(mStr);

            String kmStr = String.format("%.5f",kmNow);
            editKm.setText(kmStr);

            lastEdited = 6;
        }
    }

}
