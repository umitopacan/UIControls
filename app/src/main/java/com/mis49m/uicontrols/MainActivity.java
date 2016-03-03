package com.mis49m.uicontrols;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity {

    Button btnSave;
    RadioGroup radioGroupGender;
    CheckBox checkBox1, checkBox2;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- Read references from layout xml
        btnSave = (Button) findViewById(R.id.btnSave);
        radioGroupGender = (RadioGroup) findViewById(R.id.radio_group_gender);
        checkBox1 = (CheckBox) findViewById(R.id.check1);
        checkBox2 = (CheckBox) findViewById(R.id.check2);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        //-- Set onClickListener on Save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //-- Find selected gender
                int selectedRadioId = radioGroupGender.getCheckedRadioButtonId();
                // RadioButton selectedRadioButton = (RadioButton) radioGroupGender.findViewById(selectedRadioId);
                switch (selectedRadioId){
                    case R.id.radio_male :
                        showMessage("Male is selected");
                        break;
                    case R.id.radio_female:
                        showMessage("Female is selected");
                        break;

                }

                //-- is checkBox1 selected
                if(checkBox1.isChecked())
                    showMessage("CheckBox1 is checked");

                //-- is checkBox2 selected
                if(checkBox2.isChecked())
                    showMessage("CheckBox2 is checked");

                //-- Toggle value
                if(toggleButton.isChecked())
                    showMessage("Toggle is ON");
                else
                    showMessage("Toggle is OFF");
            }
        });

        //-- Called when the user makes changes on gender radio group
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_male :
                        showMessage("Gender changed to Male");
                        break;
                    case R.id.radio_female:
                        showMessage("Gender changed to Female");
                        break;

                }
            }
        });

        //-- Called when user clicks toggle button
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    showMessage("Toggle is ON");
                else
                    showMessage("Toggle is OFF");
            }
        });

        //-- Called when user check/uncheck checkBox1
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    showMessage("checkBox1 is checked");
                else
                    showMessage("checkBox1 is checked");
            }
        });
    }

    //-- Called when the user clicks to radio button
    public void onRadiButtonClicked(View view){
        //-- Cast reference
        RadioButton radioButton = (RadioButton) view;
        boolean isChecked = radioButton.isChecked();

        switch (radioButton.getId()){
            case R.id.radio_male :
                if(isChecked)
                    showMessage("Male is clicked");
                break;
            case R.id.radio_female:
                if(isChecked)
                    showMessage("Female is clicked");
                break;

        }

    }

    //-- Called when the user clicks on checkBox
    public void onCheckBoxClicked(View view){
        //-- Cast reference
        CheckBox checkBox = (CheckBox) view;
        boolean isChecked = checkBox.isChecked();

        switch (checkBox.getId()){
            case R.id.check1 :
                if(isChecked)
                    showMessage("CheckBox1 is checked");
                else
                    showMessage("CheckBox1 is NOT checked");
                break;
            case R.id.check2:
                if(isChecked)
                    showMessage("CheckBox2 is checked");
                else
                    showMessage("CheckBox2 is NOT checked");
                break;

        }
    }

    //-- Show text message
    private void showMessage(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
