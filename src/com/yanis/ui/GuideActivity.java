package com.yanis.ui;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author YeChao
 * @������������������activity��
 *
 */
public class GuideActivity extends Activity implements OnPageChangeListener {
	// ����ViewPager����
	private ViewPager viewPager;
	// ����һ��ArrayList�����View
	private ArrayList<View> views;
	// �����������View����
	private View view1, view2, view3, view4;
	// ���忪ʼ��ť����
	private Button btnStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		initView();

	}

	/**
	 * ��ʼ��
	 */
	private void initView() {
		// ʵ����ViewPager
		viewPager = (ViewPager) findViewById(R.id.viewpager);

		// ʵ������������Ĳ��ֶ���
		LayoutInflater mLi = LayoutInflater.from(this);
		view1 = mLi.inflate(R.layout.guide_view1, null);
		view2 = mLi.inflate(R.layout.guide_view2, null);
		view3 = mLi.inflate(R.layout.guide_view3, null);
		view4 = mLi.inflate(R.layout.guide_view4, null);

		// ʵ����ArrayList����
		views = new ArrayList<View>();
		// ��Ҫ��ҳ��ʾ��Viewװ��������
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);

		// ���ü���
		viewPager.setOnPageChangeListener(this);
		// ��������������
		viewPager.setAdapter(new ViewPagerAdapter(views));

		// ʵ������ʼ��ť
		btnStart = (Button) view4.findViewById(R.id.startBtn);
		// ����ʼ��ť���ü���
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// �������ݲ��ύ
				WelcomeActivity.sp.edit()
						.putInt("VERSION", WelcomeActivity.VERSION).commit();
				startActivity(new Intent(GuideActivity.this, MainActivity.class));
				finish();
			}

		});
	}

	/**
	 * ����״̬�ı�ʱ����
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	/**
	 * ��ǰҳ�滬��ʱ����
	 */
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	/**
	 * �µ�ҳ�汻ѡ��ʱ����
	 */
	@Override
	public void onPageSelected(int arg0) {
	}

}
