package com.jstewart.test;

import com.google.inject.Provider;
import com.jstewart.videoz.VideoPlayerActivity;

public class VideoPlayerActivityProvider implements Provider<VideoPlayerActivity> {

	@Override
	public VideoPlayerActivity get() {
		return new VideoPlayerActivity();
	}

}
