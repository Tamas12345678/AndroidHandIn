package com.example.navbarzzleep.Shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navbarzzleep.R;

public class ShopFragment extends Fragment {
    View v;
    Button button;
    Button button2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.shopfragment_layout, container,false);
        button = (Button) v.findViewById(R.id.button);


        return v;



    }
}
