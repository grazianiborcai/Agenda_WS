package br.com.mind5.config.common;

public enum ConfigValue {
	ENABLED("ENABLED"),
	DISABLED("DISABLED");
	
	
	private final String configValue;
	
	
	private ConfigValue(String value) {
		configValue = value;
	}
	
	
	
	public String getConfigValue() {
		return configValue;
	}
}
