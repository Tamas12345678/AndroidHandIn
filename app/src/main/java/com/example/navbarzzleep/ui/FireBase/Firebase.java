package com.example.navbarzzleep.ui.FireBase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navbarzzleep.MainActivity;
import com.example.navbarzzleep.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class Firebase extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private static final int CODE = 12;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {


            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(getList()).setIsSmartLockEnabled(false).build(),
                    CODE);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IdpResponse response = IdpResponse.fromResultIntent(data);
        if (CODE == requestCode) {
            Log.i("TAG", "HUKAMUKA!");
            startActivity(new Intent(this, MainActivity.class));
        } else {

        }

    }

    private List<AuthUI.IdpConfig> getList() {
        return Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );
    }
}
