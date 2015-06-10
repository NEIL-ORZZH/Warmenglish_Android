package com.kot32.warmenglish.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kot32.warmenglish.R;
import com.kot32.warmenglish.adapter.MainPageAdapter;
import com.kot32.warmenglish.model.MainFunctionTypeButtonModel;

/**
 * Created by kot32 on 15/6/10.
 */
public class MainFragment extends Fragment {

    private RecyclerView function_list;
    private MainFunctionTypeButtonModel[] models;

    private MainFragment() {
    }


    private static MainFragment instance;

    public static MainFragment newInstance() {
        if (instance == null)
            instance = new MainFragment();
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_main, null);
        function_list=(RecyclerView)view.findViewById(R.id.recycler_view);
        initControl();
        return view;
    }


    void initData() {
        models = new MainFunctionTypeButtonModel[4];

    }

    void initControl() {

        models[0] = new MainFunctionTypeButtonModel(R.drawable.ic_main_1, "做题");
        models[1] = new MainFunctionTypeButtonModel(R.drawable.ic_main_2, "通知");
        models[2] = new MainFunctionTypeButtonModel(R.drawable.ic_main_3, "我的");
        models[3] = new MainFunctionTypeButtonModel(R.drawable.ic_main_1, "任务");

        function_list.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        function_list.setAdapter(new MainPageAdapter(getActivity(), models));
    }

}
