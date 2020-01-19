package com.txl.navigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.txl.navigation.R;

public class FirstFragment extends BaseFragment implements View.OnClickListener {

    @Override
    int getLayoutRes() {
        return (R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRootView.findViewById(R.id.jump_to_second_fragment).setOnClickListener(this);
        mRootView.findViewById(R.id.jump_to_second_fragment_with_ags).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.jump_to_second_fragment) {
            NavHostFragment.findNavController(this).navigate(R.id.action_firstFragment_to_secondFragment);
        } else if (id == R.id.jump_to_second_fragment_with_ags) {
            FirstFragmentDirections.ActionFirstFragmentToSecondFragment actionFirstFragmentToSecondFragment = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
            actionFirstFragmentToSecondFragment.setCategory("我的category");
            actionFirstFragmentToSecondFragment.setNid("我的nid");
            NavHostFragment.findNavController(this).navigate(actionFirstFragmentToSecondFragment);
        }

    }
}
