package com.openclassrooms.myfragmentapp.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.myfragmentapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;


public class DetailFragment extends BaseFragment {
    //Create static variable to identify Intent
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";
    private int buttonTag;



    @BindView(R.id.fragment_detail_text_view) TextView textView;

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected BaseFragment newInstance() { return new DetailFragment();
    }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_detail; }

    @Override
    protected void configureDesign() { }

    @Override
    protected void updateDesign() {
        this.updateTextView(this.buttonTag);
    }

    // --------------
    // UPDATE UI
    // --------------

    //Update TextView depending on TAG's button
    public void updateTextView(int tag){

        //Save tag in ButtonTag variable
        this.buttonTag = tag;

        switch (tag){
            case 10:
                this.textView.setText("You're a very good programmer !");
                break;
            case 20:
                this.textView.setText("GG EZ");
                break;
            case 30:
                this.textView.setText("HEHE XD");
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Restore last buttonTag if possible
        if (savedInstanceState != null) {
            int buttonTagRestored = savedInstanceState.getInt(EXTRA_BUTTON_TAG, 0);
            //Update TextView
            this.updateTextView(buttonTagRestored);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save buttonTag in Bundle when fragment is destroyed
        outState.putInt(EXTRA_BUTTON_TAG, buttonTag);
    }
}
