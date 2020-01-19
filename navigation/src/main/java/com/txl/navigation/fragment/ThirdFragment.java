package com.txl.navigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.txl.navigation.R;

public class ThirdFragment extends BaseFragment implements View.OnClickListener {


    @Override
    int getLayoutRes() {
        return (R.layout.fragment_third);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                NavHostFragment.findNavController(ThirdFragment.this).navigate(R.id.action_thirdFragment_to_firstFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.jump_to_second_fragment) {
            NavHostFragment.findNavController(this).navigate(R.id.action_firstFragment_to_secondFragment);
        } else if (id == R.id.jump_to_second_fragment_with_ags) {
            NavHostFragment.findNavController(this).navigate(R.id.action_firstFragment_to_secondFragment);

        }

    }


}
