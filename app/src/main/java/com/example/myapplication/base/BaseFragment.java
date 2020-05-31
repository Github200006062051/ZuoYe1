package com.example.myapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(getLayoutId(),container,false);
        initView(view);
        return view;
    }

    protected abstract int getLayoutId();
    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView(View root);

    protected abstract int getlayoutId();

}
