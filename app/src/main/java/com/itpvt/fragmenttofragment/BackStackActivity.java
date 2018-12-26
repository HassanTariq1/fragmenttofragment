package com.itpvt.fragmenttofragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BackStackActivity extends AppCompatActivity {

    private Button btnFrag1WithBack,btnFrag2WithBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack);

        btnFrag1WithBack = (Button) findViewById(R.id.btnfr1with);
        btnFrag2WithBack = (Button) findViewById(R.id.btnfr2with);

        btnFrag1WithBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new OneFragment(),true,"one1");
            }
        });

        btnFrag2WithBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new TwoFragment(),true,"two2");
            }
        });
    }
// this function is used for an back click listener for fragmernt
    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_frame_back, fragment, tag);
        ft.commitAllowingStateLoss();
    }
}