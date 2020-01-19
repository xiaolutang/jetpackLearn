package com.txl.navigation.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import com.txl.navigation.R;

public class SecondFragment extends BaseFragment implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
            String category =args.getCategory();
            String nid = args.getNid();
            Log.d(TAG," 获取到参数 ：： category = "+category+"  nid = "+nid);
        }
    }

    @Override
    int getLayoutRes() {
        return (R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRootView.findViewById(R.id.jump_to_third_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.jump_to_third_fragment){
            NavDirections navDirections = SecondFragmentDirections.actionSecondFragmentToThirdFragment("","");
            NavHostFragment.findNavController(this).navigate(navDirections);
        }
    }
}
