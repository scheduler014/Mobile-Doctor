package info.androidhive.tabsswipe.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import ccs.mobileapp.mobiledoctor.AboutFragment;
import ccs.mobileapp.mobiledoctor.HomeFragment;
import ccs.mobileapp.mobiledoctor.TipsFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			
			return new HomeFragment();
		case 1:
			
			return new TipsFragment();
		case 2:
			

			return new AboutFragment();
			
		}

		return null;
	}

	@Override
	public int getCount() {
		
		return 3;
	}

}
