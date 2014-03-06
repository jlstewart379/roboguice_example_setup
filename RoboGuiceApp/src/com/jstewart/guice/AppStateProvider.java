package com.jstewart.guice;

import com.google.inject.Provider;
import com.jstewart.util.AppStateUtil;

public class AppStateProvider implements Provider<AppStateUtil> {

	@Override
	public AppStateUtil get() {
		return new AppStateUtil();
	}

}
