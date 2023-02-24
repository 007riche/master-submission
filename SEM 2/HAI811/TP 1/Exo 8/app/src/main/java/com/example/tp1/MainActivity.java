package com.example.tp1;

import static android.widget.AdapterView.INVALID_ROW_ID;
import static com.example.tp1.R.color.orange_500;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    private static final int REQUEST_CODE_SUBMISSION_CONFIRMATION = 1;

    //  SNCF_AUTH_API_KEY="d92767f5-de68-462b-b92b-8357a733ae98"

    // Authentication in request
    // https://d92767f5-de68-462b-b92b-8357a733ae98@api.navitia.io/v1/coverage/sncf/places?q=paris

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SUBMISSION_CONFIRMATION && resultCode == Activity.RESULT_OK) {
            String choice = data.getStringExtra("choice");
            System.out.println("LE RESULTAT DE LA BOITE DE DIALOGUE: "+choice);
        }

    }

}

