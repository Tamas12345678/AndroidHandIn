package com.example.navbarzzleep.Mine;

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

import com.example.navbarzzleep.R;

public class MineFragment extends Fragment {
    private TextView money;
    private Button mine;
    private ImageView chop;
    private ImageView before_chop;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);


        chop = view.findViewById(R.id.chop);
        money = view.findViewById(R.id.textView2);
        before_chop = view.findViewById(R.id.before_chop_imageView);

        mine = view.findViewById(R.id.button2);
        mine.setOnClickListener(new View.OnClickListener() {

            int gold = 0;

            @Override
            public void onClick(View v) {

                money.setText("");
                gold++;
                money.append("Gold: " + gold);

                mine.setEnabled(false);

                //State of visibility

                chop.animate().alpha(1).setDuration(0);
                before_chop.animate().alpha(0).setDuration(0);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chop.animate().alpha(0).setDuration(500);
                        before_chop.animate().alpha(1).setDuration(500);
                        mine.setEnabled(true);
                    }
                }, 5000);

            }



        });




        return view;
    }
}
