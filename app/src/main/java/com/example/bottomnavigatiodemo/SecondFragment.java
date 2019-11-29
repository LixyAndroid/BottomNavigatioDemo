package com.example.bottomnavigatiodemo;

import androidx.lifecycle.ViewModelProviders;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SecondFragment extends Fragment {

    private SecondViewModel mViewModel;
    private ImageView imageView;
    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SecondViewModel.class);

        //初始化
        imageView.setScaleX(mViewModel.scaleFactor);
        imageView.setScaleY(mViewModel.scaleFactor);


        final ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageView,"scaleX",0,0);
        objectAnimatorX.setDuration(500);

        final ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageView,"scaleY",0,0);
        objectAnimatorY.setDuration(500);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!objectAnimatorX.isRunning()){
                    objectAnimatorX.setFloatValues(imageView.getScaleX()+0.11f);
                    objectAnimatorY.setFloatValues(imageView.getScaleY()+0.11f);
                    mViewModel.scaleFactor += 0.1;
                    objectAnimatorX.start();
                    objectAnimatorY.start();

                }
            }
        });
    }

}
