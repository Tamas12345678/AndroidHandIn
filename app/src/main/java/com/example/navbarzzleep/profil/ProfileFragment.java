package com.example.navbarzzleep.profil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.navbarzzleep.R;
import com.example.navbarzzleep.network.Pokemon;

public class ProfileFragment extends Fragment {

    private View v;
    private ProfileViewModel profileViewModel;
    private EditText editText;
    private ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.list_fragment_layout, container, false);

        editText = v.findViewById(R.id.editText_changePic);
        imageView = v.findViewById(R.id.imageView_pokemon);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.getPokemon().observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                Glide.with(ProfileFragment.this).load(pokemon.getImageUrl()).into(imageView);
            }
        });

      /*  public void updatePokemon() {
            profileViewModel.updateProfilePicture(editText.getText().toString());
        }

       */

        return v;
    }
}
