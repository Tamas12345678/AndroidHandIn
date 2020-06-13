package com.example.navbarzzleep.Mine;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navbarzzleep.R;

public class MineFragment extends Fragment {
    private TextView moneyTextView;
    private Button mine;
    private ImageView chops;
    private ImageView before_chop;
    private MineViewModel viewModel;

    public String text;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        viewModel = new ViewModelProvider(this).get(MineViewModel.class);

        moneyTextView = view.findViewById(R.id.textView2);

        preferences = getActivity().getSharedPreferences("saved", Context.MODE_PRIVATE);
        editor = preferences.edit();
        viewModel.mining(preferences.getInt("money", 0));

        viewModel.getMoney().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                moneyTextView.setText("Gold: " + integer);
            }
        });

        chops = view.findViewById(R.id.chop);
        before_chop = view.findViewById(R.id.before_chop_imageView);
        chops.animate().alpha(0).setDuration(0);

        mine = view.findViewById(R.id.button2);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //State of visibility
                chops.animate().alpha(1).setDuration(0);
                before_chop.animate().alpha(0).setDuration(0);
                mine.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chops.animate().alpha(0).setDuration(500);
                        before_chop.animate().alpha(1).setDuration(500);
                        mine.setEnabled(true);
                    }
                }, 1000);

                int current = (preferences.getInt("money", 0)) + 1;
                editor.putInt("money", current);
                editor.apply();
                viewModel.mining(current);
            }
        });

        return view;
    }
}
