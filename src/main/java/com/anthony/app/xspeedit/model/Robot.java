package com.anthony.app.xspeedit.model;

import com.anthony.app.xspeedit.Interface.Logiciel;

public abstract class Robot implements Logiciel {

	protected String reference;

	protected Robot(String reference) {
		super();
		this.reference = reference;
	}
	
}
