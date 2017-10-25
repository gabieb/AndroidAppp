package com.app;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    Firebase objRef;
    Firebase objRef1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        objRef = new Firebase("https://controlador-ec734.firebaseio.com/Constantes");

        Button KDButton = (Button)findViewById(R.id.KD_button);
        Button KIButton = (Button)findViewById(R.id.KI_button);
        Button KPButton = (Button)findViewById(R.id.KP_button);
        Button KTButton = (Button)findViewById(R.id.KT_button);
        final EditText kdText = (EditText)findViewById(R.id.editText_KD);
        final EditText kiText = (EditText)findViewById(R.id.editText_KI);
        final EditText kpText = (EditText)findViewById(R.id.editText_KP);
        final EditText ktText = (EditText)findViewById(R.id.editText_KT);
        final TextView Text = (TextView)findViewById(R.id.textView_input);

        KDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kd = kdText.getText().toString();
                objRef.child("KD").setValue(kd);
                kdText.setText("");
            }
        });

        KIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ki = kiText.getText().toString();
                objRef.child("KI").setValue(ki);
                kiText.setText("");
            }
        });

        KPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kp = kpText.getText().toString();
                objRef.child("KP").setValue(kp);
                kpText.setText("");
            }
        });

        KTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kt = ktText.getText().toString();
                objRef.child("KT").setValue(kt);
                ktText.setText("");
            }
        });

        objRef1 = new Firebase("https://controlador-ec734.firebaseio.com/Leitura");

        objRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Text.setText((String)dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
}
