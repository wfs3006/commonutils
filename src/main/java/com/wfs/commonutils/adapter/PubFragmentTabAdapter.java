package com.wfs.commonutils.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/**
 * 
 * @ClassName: PubFragmentTabAdapter 
 * @Description: 公用的tab+fragment适配器
 * @author WangFusheng 
 * @date 2015年9月1日 上午10:15:20
 */
public class PubFragmentTabAdapter extends FragmentPagerAdapter {
	FragmentManager fm;
	private List<Fragment> fragments;
	String titles[];
	public PubFragmentTabAdapter(FragmentManager fm) {
		super(fm);
	}
	public PubFragmentTabAdapter(FragmentManager fm,String[] titles,List<Fragment> fragments) {
		super(fm);
		this.titles = titles;
		this.fragments  = fragments;
		this.fm = fm;
	}
	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position % titles.length];
	}

	@Override
	public int getCount() {
		return titles.length;
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return ((Fragment) arg1).getView() == arg0;
	}

	public Fragment getItem(int position) {
		return fragments.get(position);
	}
	protected String getTag(int position) {
		return titles[position];
	}
	@Override
    public int getItemPosition(Object object){   
        return POSITION_NONE;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		return super.instantiateItem(container, position);
	}


}
