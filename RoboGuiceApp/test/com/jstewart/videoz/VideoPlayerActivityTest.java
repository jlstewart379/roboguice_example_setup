package com.jstewart.videoz;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.Robolectric.shadowOf;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowDialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.jstewart.test.BaseTest;
import com.jstewart.test.TestGuiceModule;
import com.jstewart.util.AppStateUtil;

public class VideoPlayerActivityTest extends BaseTest {

	private VideoPlayerActivity mActivity;
	@Mock
	private AppStateUtil mockAppStateUtil;

	@Before
	public void setUp() {
		super.setUp(); 
		module.addBinding(AppStateUtil.class, mockAppStateUtil);
		TestGuiceModule.setUp(this, module);
	}

	@Test
	public void itCallsAppStateProvider() {
		startActivityForInitalUser();
		verify(mockAppStateUtil).isInitialRun((Context) Mockito.anyObject());
	}

	@Test
	public void itShowsWelcomeDialog() {
		startActivityForInitalUser();
		Dialog dialog = ShadowDialog.getLatestDialog();
		ShadowDialog shadowDialog = shadowOf(dialog);
		assertThat(shadowDialog.getTitle().toString(), is("Welcome to Videoz"));
	}

	private void startActivityForInitalUser() {
		when(mockAppStateUtil.isInitialRun((Activity) anyObject())).thenReturn(
				true);
		mActivity = Robolectric.buildActivity(VideoPlayerActivity.class)
				.create().start().resume().get();
	}

}
