package com.yanis.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class WelcomeActivity extends Activity implements Runnable {
	public static final int VERSION = 1;
	public static SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		// 启动一个延迟线程
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			// 延迟两秒时间
			Thread.sleep(2000);
			// 读取SharedPreferences中需要的数据
			sp = getSharedPreferences("Y_Setting", Context.MODE_PRIVATE);
			/**
			 * 如果用户不是第一次使用则直接调转到显示界面,否则调转到引导界面
			 */
			if (sp.getInt("VERSION", 0) != VERSION) {
				startActivity(new Intent(WelcomeActivity.this,
						GuideActivity.class));
			} else {
				startActivity(new Intent(WelcomeActivity.this,
						MainActivity.class));
			}
			finish();

		} catch (Exception e) {
		}
	}
}
