package com.yanis.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public class WelcomeActivity extends Activity implements Runnable {
	// �Ƿ��ǵ�һ��ʹ��
	private boolean isFirstUse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		// ����һ���ӳ��߳�
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			// �ӳ�����ʱ��
			Thread.sleep(2000);
			// ��ȡSharedPreferences����Ҫ������
			SharedPreferences preferences = this.getSharedPreferences(
					"isFirstUse", Context.MODE_PRIVATE);

			isFirstUse = preferences.getBoolean("isFirstUse", true);

			/**
			 * ����û����ǵ�һ��ʹ����ֱ�ӵ�ת����ʾ����,�����ת����������
			 */
			if (isFirstUse) {
				startActivity(new Intent(WelcomeActivity.this,
						GuideActivity.class));
			} else {
				startActivity(new Intent(WelcomeActivity.this,
						MainActivity.class));
			}
			// ʵ����Editor����
			Editor editor = preferences.edit();
			// ��������
			editor.putBoolean("isFirstUse", false);
			// �ύ�޸�
			editor.commit();
			finish();

		} catch (Exception e) {
		}
	}
}
