package com.example.navbarzzleep.Shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbarzzleep.R;
import com.example.navbarzzleep.local_database.entity.Pocket;

import java.util.List;

public class ListFragment extends Fragment {
    private View v;
    private Button button;
    private Button delete;
    private CheckBox checkBox;
    private EditText text;

    //ViewModel
    private ListViewModel listViewModel;

    private List<ListItem> texts;

    private RecyclerView mToDoList;
    private RecycleViewAdapter mListAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        v = inflater.inflate(R.layout.shopfragment_layout, container, false);


        //button = (Button) v.findViewById(R.id.button);

        //Recycle view

        mToDoList = v.findViewById(R.id.recycleView);

        mToDoList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mToDoList.setHasFixedSize(true);


        mListAdapter = new RecycleViewAdapter();
        mToDoList.setAdapter(mListAdapter);


        //Add to the database
        button = v.findViewById(R.id.add_button);
        text = v.findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listViewModel.addToList(new Pocket(text.getText().toString()));
                text.setText("");
            }
        });

        //Delete everything from database table
        delete = v.findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewModel.deleteAll();
            }
        });



        //getList
        listViewModel.getAllText().observe(getViewLifecycleOwner(), new Observer<List<Pocket>>() {
            @Override
            public void onChanged(List<Pocket> pockets) {
                mListAdapter.setList(pockets);
            }
        });


        return v;


    }


}
