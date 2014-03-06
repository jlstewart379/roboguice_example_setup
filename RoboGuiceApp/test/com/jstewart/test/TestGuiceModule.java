package com.jstewart.test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.robolectric.Robolectric;

import roboguice.RoboGuice;
import roboguice.config.DefaultRoboModule;
import roboguice.inject.ContextSingleton;
import roboguice.inject.RoboInjector;
import android.app.Application;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.jstewart.guice.VideoGuiceModule;
import com.jstewart.videoz.VideoFragment;
import com.jstewart.videoz.VideoPlayerActivity;

public class TestGuiceModule extends AbstractModule {

	private HashMap<Class<?>, Object> bindings;

	public TestGuiceModule() {
		bindings = new HashMap<Class<?>, Object>();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void configure() {
		bind(VideoPlayerActivity.class).toProvider(VideoPlayerActivityProvider.class).in(
				ContextSingleton.class);
		bind(VideoFragment.class).toProvider(VideoFragmentProvider.class).in(
				ContextSingleton.class);
		Set<Entry<Class<?>, Object>> entries = bindings.entrySet();

		for (Entry<Class<?>, Object> entry : entries) {
			bind((Class<Object>) entry.getKey()).toInstance(entry.getValue());
		}
	}

	public static void setUp(Object testObject, TestGuiceModule module) {

		DefaultRoboModule roboGuiceModule = RoboGuice
				.newDefaultRoboModule(Robolectric.application);
		Module videoModule = Modules.override(roboGuiceModule).with(
				new VideoGuiceModule());
		Module testModule = Modules.override(videoModule).with(module);
		RoboGuice.setBaseApplicationInjector(Robolectric.application,
				RoboGuice.DEFAULT_STAGE, testModule);
		RoboInjector injector = RoboGuice.getInjector(Robolectric.application);
		injector.injectMembers(testObject);
	}

	public static void tearDown() {
		RoboGuice.util.reset();
		Application app = Robolectric.application;
		DefaultRoboModule defaultModule = RoboGuice.newDefaultRoboModule(app);
		RoboGuice.setBaseApplicationInjector(app, RoboGuice.DEFAULT_STAGE,
				defaultModule);

	}

	public void addBinding(Class<?> clazz, Object object) {
		bindings.put(clazz, object);

	}

}
