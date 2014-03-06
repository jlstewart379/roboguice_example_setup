package com.jstewart.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jstewart.util.AppStateUtil;
import com.jstewart.util.BundleRetriever;

public class WelcomeGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AppStateUtil.class).toProvider(AppStateProvider.class);
		bind(BundleRetriever.class).toProvider(BundleProvider.class);
	}

}
