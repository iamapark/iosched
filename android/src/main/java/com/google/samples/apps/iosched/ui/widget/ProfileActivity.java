package com.google.samples.apps.iosched.ui.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.samples.apps.iosched.R;
import com.google.samples.apps.iosched.ui.BaseActivity;
import com.google.samples.apps.iosched.ui.SearchActivity;
import com.google.samples.apps.iosched.util.AnalyticsManager;

/**
 * Created by jinyoungpark on 14. 8. 8.
 */
// Todo: 프로필 화면에서 좌측 상단 눌렀을때 뒤로가기 되는 것
public class ProfileActivity extends BaseActivity  {

    private static final String SCREEN_LABEL = "프로필";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                /* [ANALYTICS:EVENT]
                 * TRIGGER:   Click the search button on the Explore screen.
                 * CATEGORY:  'Explore'
                 * ACTION:    'launchsearch'
                 * LABEL:     (none)
                 * [/ANALYTICS]
                 */
                AnalyticsManager.sendEvent(SCREEN_LABEL, "launchsearch", "");
                startActivity(new Intent(this, SearchActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
