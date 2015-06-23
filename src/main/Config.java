package main;

import java.util.ResourceBundle;

public final class Config {

	private static final Config instance = new Config();

	private final ResourceBundle rb = ResourceBundle.getBundle(this.getClass().getName().toLowerCase());

	private Config() {
	}

	public static final Config getInstance() {
		return instance;
	}

	// //////////////////////////////////////////////////////////////////////////
	private String getString(final String nome) {
		return rb.getString(nome);
	}

	private int getInt(final String nome) {
		return Integer.parseInt(getString(nome));
	}

	private long getLong(final String nome) {
		return Long.parseLong(getString(nome));
	}
	// //////////////////////////////////////////////////////////////////////////

	/*
	 * AUTO-GENERATED source goes here!!!
	 */

}
