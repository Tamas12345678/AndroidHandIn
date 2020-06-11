package com.example.navbarzzleep.Shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.navbarzzleep.R;

public class ListFragment extends Fragment {
    View v;
    Button button;
   CheckBox checkBox;

   //ViewModel
    private ListViewModel listViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);

        v = inflater.inflate(R.layout.shopfragment_layout, container,false);
        //button = (Button) v.findViewById(R.id.button);


        return v;



    }
}
