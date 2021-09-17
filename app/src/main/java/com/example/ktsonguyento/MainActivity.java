package com.example.ktsonguyento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtSoNguyen;
    private Button btnSoCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    private void addControls(){
        edtSoNguyen=(EditText) findViewById(R.id.edtSoNguyen);
        btnSoCheck=(Button) findViewById(R.id.btnCheck);

    }
    private void addEvents(){
        edtSoNguyen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edtSoNguyen.getLineCount()==0) btnSoCheck.setEnabled(false);
                else
                    btnSoCheck.setEnabled(true);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private boolean nguyenTo(int n){
        for(int  i = 2;i<=Math.sqrt(n);i++)
            if(n%i==0)return false;
            return true;
    }
    public void checkNguyenTo(View view){
        int n=Integer.parseInt(edtSoNguyen.getText().toString());
        if(nguyenTo(n)){
            Toast.makeText(this,n+" Là số nguyên tố", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,n+" Không phải là số nguyên tố", Toast.LENGTH_LONG).show();
        }
    }
}