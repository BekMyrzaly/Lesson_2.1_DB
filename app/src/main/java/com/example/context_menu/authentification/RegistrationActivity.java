package com.example.context_menu.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.context_menu.R;
import com.example.context_menu.database.StoreDatabase;

import static com.example.context_menu.database.StoreDatabase.COLUMN_USER_EMAIL;
import static com.example.context_menu.database.StoreDatabase.COLUMN_USER_NAME;
import static com.example.context_menu.database.StoreDatabase.COLUMN_USER_PASSWORD;
import static com.example.context_menu.database.StoreDatabase.COLUMN_USER_PHONE;
import static com.example.context_menu.database.StoreDatabase.TABLE_USERS;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {


    private StoreDatabase storeDb;
    private SQLiteDatabase sqdb;

    EditText et_user_name;
    EditText et_email;
    EditText et_password;
    EditText et_phone;
    Button btn_submit;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        storeDb = new StoreDatabase(this);
        sqdb = storeDb.getWritableDatabase();

        et_user_name = findViewById(R.id.et_user_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_phone = findViewById(R.id.et_phone);
        btn_submit = findViewById(R.id.btn_submit);
        btn_login = findViewById(R.id.btn_login);

        btn_submit.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_submit:
                if (TextUtils.isEmpty(et_user_name.getText())) {
                    et_user_name.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_email.getText())) {
                    et_email.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_password.getText())) {
                    et_password.setError("Fill again");
                    return;
                }

                if (TextUtils.isEmpty(et_phone.getText())) {
                    et_phone.setError("Fill again");
                    return;
                }

                ContentValues versionValues = new ContentValues();
                versionValues.put(COLUMN_USER_NAME, et_user_name.getText().toString());
                versionValues.put(COLUMN_USER_EMAIL, et_email.getText().toString());
                versionValues.put(COLUMN_USER_PASSWORD, et_password.getText().toString());
                versionValues.put(COLUMN_USER_PHONE, et_phone.getText().toString());

                sqdb.insert(TABLE_USERS, null, versionValues);
                Toast.makeText(this, "Database saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_login:
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);
                break;
        }


    }
}

