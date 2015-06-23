package main;

import java.util.Enumeration;
import java.util.ResourceBundle;

public final class Configger {

	private static final char _N = '\n';

	private final ResourceBundle rb = ResourceBundle.getBundle(this.getClass().getName().toLowerCase());

	private Configger() {
	}

	public static void main(String[] args) {
		new Configger().start();
	}

	private void start() {
		final StringBuilder template = new StringBuilder();
		template.append("    public final %s get%s() {").append(_N);
		template.append("        return get%s('%s');").append(_N);
		template.append("    }").append(_N);
		template.append(_N);
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			final String out = format(template.toString(), keys.nextElement());
			{
				System.out.print(out);
			}
		}
	}

	private final String format(String str, String key) {
		String type = type(key);
		return String.format(str, type, getter(key), capitalizeFirst(type), key).replaceAll("'", "\"");
	}

	private String type(String key) {
		if (key.startsWith("INTERVAL_"))
			return "int";
		else if (key.startsWith("COD_"))
			return "long";
		else
			return "String";
	}

	private final String getter(String key) {
		return capitalizeUnderscore(key);
	}

	private String capitalizeFirst(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

	private String capitalizeUnderscore(String str) {
		StringBuilder sb = new StringBuilder();
		String[] parts = str.split("_");
		for (String part : parts)
			sb.append(capitalizeFirst(part));
		return sb.toString();
	}

}
