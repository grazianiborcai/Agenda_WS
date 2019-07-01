package br.com.gda.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public final class JsonAttrExclusion implements ExclusionStrategy {
	private final boolean SKIP = true;
	private final boolean DONT_SKIP = false;
	
	
	@Override public boolean shouldSkipField(FieldAttributes f) {
		if (f.getName().equals("recordMode"))
			return SKIP;
		
		if (f.getName().equals("recordFlag"))
			return SKIP;
		
		if (f.getName().equals("second"))
			return SKIP;
		
		if (f.getName().equals("nano"))
			return SKIP;
		
		if (f.getName().equals("creditCardId"))
			return SKIP;
		
		if (f.getName().equals("customerId"))
			return SKIP;
		
		return DONT_SKIP;
	}

	
	
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return DONT_SKIP;
	}
}
