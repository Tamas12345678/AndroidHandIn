package com.example.navbarzzleep.profil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.navbarzzleep.Mine.MineFragment;
import com.example.navbarzzleep.R;
import com.example.navbarzzleep.network.Pokemon;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    private View v;
    private ProfileViewModel profileViewModel;
    private EditText editText;
    private ImageView imageView;
    private Button button;
    private MineFragment mineFragment;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private TextView profileGold;
    private Button logout;
    private FirebaseAuth mAuth;


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pokemon_fragment_layout, container, false);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        editText = v.findViewById(R.id.editText_changePic);
        imageView = v.findViewById(R.id.imageView_pokemon);
        button = v.findViewById(R.id.button_setNew);
        profileGold = v.findViewById(R.id.profileGold);
        logout = v.findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();

        preferences = getActivity().getSharedPreferences("saved", Context.MODE_PRIVATE);
        editor = preferences.edit();

        profileViewModel.getMoney().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

                if (integer < 5) {
                    profileGold.setText("Not enough currency!     Gold: " + integer);
                    editText.setEnabled(false);
                    button.setEnabled(false);
                } else {
                    profileGold.setText("Gold: " + integer);
                    editText.setEnabled(true);
                    button.setEnabled(true);
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {

                    profileViewModel.updateProfilePicture(editText.getText().toString());

                    int current = (preferences.getInt("money", 0)) -5;
                    editor.putInt("money", current);
                    editor.apply();
                    profileViewModel.mining(current);
                    editText.setText("");
                }

            }
        });


        profileViewModel.getPokemon().observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                Log.i("FLOW", "OH YEAH");
                Glide.with(ProfileFragment.this).load(pokemon.getImageUrl()).into(imageView);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

            }
        });

        return v;
    }


}