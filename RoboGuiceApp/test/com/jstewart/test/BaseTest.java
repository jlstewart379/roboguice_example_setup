package com.jstewart.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public abstract class BaseTest {

	protected TestGuiceModule module;

	@Before
	public void setUp() {
		module = new TestGuiceModule();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void after() {
		TestGuiceModule.tearDown();
	}

}
