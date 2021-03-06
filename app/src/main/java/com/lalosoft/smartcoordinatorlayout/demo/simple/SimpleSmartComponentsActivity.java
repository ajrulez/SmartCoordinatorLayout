package com.lalosoft.smartcoordinatorlayout.demo.simple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.lalosoft.smartcoordinatorlayout.SmartCoordinatorLayout;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomSmartRecyclerView;
import com.lalosoft.smartcoordinatorlayout.demo.OnItemSelectedListener;
import com.lalosoft.smartcoordinatorlayout.demo.R;
import com.lalosoft.smartcoordinatorlayout.demo.custom.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo.Martin on 11/16/2016
 */

public class SimpleSmartComponentsActivity extends AppCompatActivity {

    private static final int ITEM_RECYCLER_VIEW = 0;
    private static final int ITEM_FAB = 1;
    private static final int ITEM_TAB_LAYOUT = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.simple_smart_components);
        }

        // bind the root of view of this activity
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_base_root);

        CustomSmartRecyclerView smartRecyclerView = new CustomSmartRecyclerView(new CustomAdapter(this,
                createStringList(), new OnItemSelectedListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case ITEM_RECYCLER_VIEW:
                        openActivity(SimpleSmartRecyclerViewActivity.class);
                        break;
                    case ITEM_FAB:
                        openActivity(SimpleSmartFABActivity.class);
                        break;
                    case ITEM_TAB_LAYOUT:
                        openActivity(SimpleSmartTabLayoutActivity.class);
                        break;
                }
            }
        }));

        // build SmartCoordinatorLayout
        SmartCoordinatorLayout
                smartCoordinatorLayout = new SmartCoordinatorLayout.Builder(this)
                .buildWithView(rootView)
                .addSmartComponent(smartRecyclerView)
                .build();

        smartCoordinatorLayout.setup();
    }

    private List<String> createStringList() {
        List<String> list = new ArrayList<>();
        list.add(getString(R.string.simple_smart_recycler_view));
        list.add(getString(R.string.simple_smart_floating_action_button));
        list.add(getString(R.string.simple_smart_tab_layout));
        return list;
    }

    private void openActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }

}
