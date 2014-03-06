package com.jstewart.welcome;

import roboguice.fragment.RoboFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.inject.Inject;
import com.jstewart.util.BundleRetriever;

public class WelcomeFragment extends RoboFragment {

	private @Inject
	BundleRetriever retriever;
	private static final String URL = "url";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		retriever.getString(URL);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_welcome, container);
		return v;
	}

}
