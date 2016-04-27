package com.example.lo.gsb_frais_kilometrique_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Passerelle extends AppCompatActivity {


    private TextView switchStatus;
    private TextView switchStatus2;
    private Switch SwitchDiesel;
    private Switch SwitchEssence;
    private Switch Switch4CV;
    private Switch Switch5_6CV;
    private double intKm;
    private EditText km;
    private String km1;
    private float floatPF;
    private Button calculer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passerelle);

        SwitchDiesel = (Switch) findViewById(R.id.switch1);
        SwitchEssence = (Switch) findViewById(R.id.switch2);
        Switch4CV = (Switch) findViewById(R.id.switch4);
        Switch5_6CV = (Switch) findViewById(R.id.switch3);



        calculer =(Button) findViewById(R.id.button);

        switchStatus = (TextView) findViewById(R.id.textView4);
        switchStatus2 = (TextView) findViewById(R.id.textView5);
        //set the switch to ON
        SwitchDiesel.setChecked(false);
        SwitchEssence.setChecked(false);
        Switch4CV.setChecked(false);
        Switch5_6CV.setChecked(false);
        //attach a listener to check for changes in state
        SwitchDiesel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {


                if (SwitchDiesel.isChecked())
                {
                    SwitchEssence.setChecked(false);
                    if (Switch4CV.isChecked() && SwitchDiesel.isChecked())
                    {
                        switchStatus.setText("La voiture est une diesel de 4CV");
                    }
                    else if(Switch5_6CV.isChecked() && SwitchDiesel.isChecked()){
                        switchStatus.setText("La voiture est une diesel de 5/6CV");
                    }
                }



                else{
                    SwitchDiesel.setChecked(false);
                }
            }
        });
        SwitchEssence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {


                if (SwitchEssence.isChecked())
                {
                    SwitchDiesel.setChecked(false);
                    if (Switch4CV.isChecked())
                    {
                        Switch5_6CV.setChecked(false);
                        if (Switch4CV.isChecked() && SwitchDiesel.isChecked())
                        {
                            switchStatus.setText("La voiture est une diesel de 4CV");
                        }
                        else if(Switch5_6CV.isChecked() && SwitchDiesel.isChecked()){
                            switchStatus.setText("La voiture est une diesel de 5/6CV");
                        }
                    }

                }
                else{
                    SwitchEssence.setChecked(false);
                }
            }
        });
        Switch4CV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {


                if (Switch4CV.isChecked())
                {
                    Switch5_6CV.setChecked(false);
                    if (Switch4CV.isChecked() && SwitchEssence.isChecked())
                    {
                        switchStatus.setText("La voiture est une essence de 4CV");
                    }
                    else if(Switch5_6CV.isChecked() && SwitchDiesel.isChecked()){
                        switchStatus.setText("La voiture est une diesel de 5/6CV");
                    }
                }
                else{
                    Switch4CV.setChecked(false);
                }
            }
        });
        Switch5_6CV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {


                if (Switch5_6CV.isChecked())
                {
                    Switch4CV.setChecked(false);
                    if (Switch5_6CV.isChecked() && SwitchEssence.isChecked())
                    {
                        switchStatus.setText("La voiture est une essence de 5/6CV");
                    }
                    else if (Switch5_6CV.isChecked() && SwitchDiesel.isChecked()){
                        switchStatus.setText("La voiture est une diesel de 5/6CV");
                    }
                }
                else{
                    Switch5_6CV.setChecked(false);
                }
            }
        });

        final Button calculer= (Button) findViewById(R.id.button);
        calculer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                km = (EditText) findViewById(R.id.editText);
                assert km != null;
                km1 = km.getText().toString();
                intKm = Double.parseDouble(km1);
                if (SwitchDiesel.isChecked() && Switch4CV.isChecked()){

                    intKm = intKm * 0.52;

                    switchStatus2.setText(String.valueOf(intKm));
                }
                else if (SwitchDiesel.isChecked() && Switch5_6CV.isChecked()){

                    intKm = intKm * 0.58;
                    switchStatus2.setText(String.valueOf(intKm));
                }
                else if (SwitchEssence.isChecked() && Switch4CV.isChecked()){

                    intKm = intKm * 0.62;
                    switchStatus2.setText(String.valueOf(intKm));
                }
                else if (SwitchEssence.isChecked() && Switch5_6CV.isChecked()){

                    intKm = intKm * 0.67;
                    switchStatus2.setText(String.valueOf(intKm));
                }
            }

        });
    }
}