package com.jstewart.welcome;

import roboguice.activity.RoboFragmentActivity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.inject.Inject;
import com.jstewart.util.AppStateUtil;

public class WelcomeActivity extends RoboFragmentActivity{

	@Inject
	private AppStateUtil mAppStateUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

	}

	@Override
	protected void onResume() {
		super.onResume();
		if (mAppStateUtil.isInitialRun(this)) {
			Dialog dialog = new Dialog(this);
			dialog.setTitle(R.string.welcome_message);
			dialog.show();
		}
	}

}
