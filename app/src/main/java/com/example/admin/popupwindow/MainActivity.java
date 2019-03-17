package com.example.admin.popupwindow;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Dialog myDialog;
    EditText firstname,lastname,enno,mail,phonenumber,password;

    Button button;

    DatabaseReference databasestudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);


    }
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.activity_popup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnFollow = (Button) myDialog.findViewById(R.id.btn);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
        myDialog.show();

        databasestudent=FirebaseDatabase.getInstance().getReference("Student");

        firstname=(EditText) myDialog.findViewById(R.id.fn);
        lastname=(EditText) myDialog.findViewById(R.id.ln);
        enno=(EditText) myDialog.findViewById(R.id.en);
        mail=(EditText) myDialog.findViewById(R.id.email);
        phonenumber=(EditText) myDialog.findViewById(R.id.pn);
        password=(EditText) myDialog.findViewById(R.id.pass);

        button=(Button) myDialog.findViewById(R.id.btn1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store();
            }
        });

    }
    public void store() {
        String fname=firstname.getText().toString().trim();
        String lname=lastname.getText().toString().trim();
        String email=mail.getText().toString().trim();
        String ennumber=enno.getText().toString().trim();
        String pnumber=phonenumber.getText().toString().trim();
        String pass=password.getText().toString().trim();

        if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(ennumber) && !TextUtils.isEmpty(pnumber) && !TextUtils.isEmpty(pass)){

            String id=databasestudent.push().getKey();

            data dt=new data(id,fname,lname,email,ennumber,pnumber,pass);

            databasestudent.child(id).setValue(dt);

            Toast.makeText(this,"Details Added",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Enter All Details ",Toast.LENGTH_LONG).show();
        }
    }
}
