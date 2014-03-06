package com.jstewart.videoz;

import static org.mockito.Mockito.verify;
import static org.robolectric.util.FragmentTestUtil.startFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.inject.Inject;
import com.jstewart.test.BaseTest;
import com.jstewart.test.TestGuiceModule;
import com.jstewart.util.BundleRetriever;

public class VideoFragmentTests extends BaseTest {

	@Mock
	private BundleRetriever mockBundleRetriever;

	private @Inject
	VideoFragment mVideoFragment;

	@Before
	public void setUp() {
		super.setUp();
		module.addBinding(BundleRetriever.class, mockBundleRetriever);
		TestGuiceModule.setUp(this, module);
		startFragment(mVideoFragment);
	}

	@Test
	public void itGetsTheVideoKeyFromTheBundle() {
		verify(mockBundleRetriever).getString("video_url");
	}
}
