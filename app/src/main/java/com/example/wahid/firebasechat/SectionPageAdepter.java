package com.example.wahid.firebasechat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;

class SectionPageAdepter extends FragmentPagerAdapter {



    public SectionPageAdepter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0:
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;

            case 1:
                ChattingFragment chattingFragment = new ChattingFragment();
                return chattingFragment;
            case 2:
                FriendsFragment friendsFragment = new FriendsFragment();
                return friendsFragment;
             default:
                 return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "REQUEST";
            case 1:
                return "Chat";
            case  2:
                return "FRIENDS";
                default:
                    return null;

        }
    }
}
