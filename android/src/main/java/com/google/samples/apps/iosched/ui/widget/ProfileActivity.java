package com.google.samples.apps.iosched.ui.widget;

import android.os.Bundle;

import com.google.samples.apps.iosched.R;
import com.google.samples.apps.iosched.ui.BaseActivity;
import com.google.samples.apps.iosched.util.AnalyticsManager;

/**
 * Created by jinyoungpark on 14. 8. 8.
 */
public class ProfileActivity extends BaseActivity  {

    private static final String SCREEN_LABEL = "프로필";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getLPreviewUtils().trySetActionBar();

        AnalyticsManager.sendScreenView(SCREEN_LABEL);
    }

}
