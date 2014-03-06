package com.jstewart.guice;

import com.google.inject.Provider;
import com.jstewart.util.BundleRetriever;

public class BundleProvider implements Provider<BundleRetriever> {

	@Override
	public BundleRetriever get() {
		return new BundleRetriever();
	}

}
