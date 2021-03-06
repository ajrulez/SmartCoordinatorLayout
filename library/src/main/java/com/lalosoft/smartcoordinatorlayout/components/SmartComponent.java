package com.lalosoft.smartcoordinatorlayout.components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gonzalo.Martin on 10/6/2016
 */
public interface SmartComponent {

    /**
     * Setup of {@link SmartComponent}
     * @param context the current {@link Context}
     * @param viewGroup the parent view
     * @return a new {@link View} with the added {@link SmartComponent}
     */
    View setup(Context context, ViewGroup viewGroup);
}
