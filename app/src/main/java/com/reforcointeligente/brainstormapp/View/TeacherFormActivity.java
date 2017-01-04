package com.reforcointeligente.brainstormapp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.reforcointeligente.brainstormapp.Model.Teacher;
import com.reforcointeligente.brainstormapp.R;

public class TeacherFormActivity extends AppCompatActivity {
    Spinner spinner;
    boolean hasCar;
    Button confirmTeacherButton;
    Button cancelTeacherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_form);
        setUpSpinner();

        cancelTeacherButton = (Button) findViewById(R.id.buttonCancelTeacher);
        cancelTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        confirmTeacherButton = (Button) findViewById(R.id.buttonConfirmTeacher);
        confirmTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void setUpSpinner() {
        spinner = (Spinner) findViewById(R.id.spinnerTeacherCity);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.list_df_cities, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButtonYes:
                if (checked)
                    hasCar = true;
                    break;
            case R.id.radioButtonNo:
                if (checked)
                    hasCar = false;
                    break;
        }
    }

    public void onTeacherCreated() {

    }
}
