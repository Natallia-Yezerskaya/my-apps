package com.test.myapplication.ui;

import android.support.v4.app.Fragment;

public interface ActivityListener {

    void setTitle(String title);
    void setMenuIconState(MaterialMenuDrawable.IconState state);
    void changeFragment(Fragment fragment);
}
