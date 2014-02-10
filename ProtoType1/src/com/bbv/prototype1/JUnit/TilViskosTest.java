package com.bbv.prototype1.JUnit;

import com.bbv.prototype1.Til_Viskos;

import android.test.AndroidTestCase;

public class TilViskosTest extends AndroidTestCase {

	Til_Viskos test;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		test = new Til_Viskos(getContext());
	}

	public void testCalculationIntFloatFloat() {
		assertEquals("Testing calculation", "300.0", test.calculation(0, 56, 56));
	}

}
