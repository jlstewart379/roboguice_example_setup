package com.jstewart.test;

import com.google.inject.Provider;
import com.jstewart.videoz.VideoFragment;

public class VideoFragmentProvider implements Provider<VideoFragment> {

	@Override
	public VideoFragment get() {
		return new VideoFragment();
	}

}
