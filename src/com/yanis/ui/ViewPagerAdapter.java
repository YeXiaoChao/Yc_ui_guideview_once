package com.yanis.ui;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 
 * @author YeChao
 * @����������ViewPager�����������������ݺ�view
 *
 */
public class ViewPagerAdapter extends PagerAdapter {
	// �����б�
	private ArrayList<View> views;

	public ViewPagerAdapter(ArrayList<View> views) {
		this.views = views;
	}

	/**
	 * ��õ�ǰ������
	 */
	@Override
	public int getCount() {
		if (views != null) {
			return views.size();
		} else
			return 0;
	}

	/**
	 * �ж��Ƿ��ɶ������ɽ���
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);
	}

	/**
	 * ����positionλ�õĽ���
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	/**
	 * ��ʼ��positionλ�õĽ���
	 */
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);
		return views.get(position);
	}

}
