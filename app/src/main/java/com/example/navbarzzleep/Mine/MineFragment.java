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

import com.example.navbarzzleep.R;

public class MineFragment extends Fragment {
    private TextView money;
    private Button mine;
    private ImageView chops;
    private ImageView before_chop;

    public static final String SHARED_PREF = "shared";
    public static final String TEXT = "gold";
    public String text;
    private String money2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);


        chops = view.findViewById(R.id.chop);
        money = view.findViewById(R.id.textView2);
        before_chop = view.findViewById(R.id.before_chop_imageView);

        chops.animate().alpha(0).setDuration(0);

        money.setText("Gold");

        mine = view.findViewById(R.id.button2);
        mine.setOnClickListener(new View.OnClickListener() {

            int gold = 0;

            @Override
            public void onClick(View v) {

                money.setText("");
                money2 = String.valueOf(gold);
                gold++;
               // money.append("Gold: " + money2);
                money.setText("Gold: "+ money2);
                mine.setEnabled(false);

                //State of visibility

                chops.animate().alpha(1).setDuration(0);
                before_chop.animate().alpha(0).setDuration(0);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chops.animate().alpha(0).setDuration(500);
                        before_chop.animate().alpha(1).setDuration(500);
                        mine.setEnabled(true);
                    }
                }, 500);


                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEXT,money.getText().toString());
                editor.apply();
            }





        });




        update();

        return view;
    }

    private void update()
    {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
        //text =  sharedPreferences.getString(TEXT,"");
        money.setText(text);
    }
}
