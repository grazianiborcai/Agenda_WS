package br.com.gda.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public final class JsonAttrExclusion implements ExclusionStrategy {
	private final boolean SKIP = true;
	private final boolean DONT_SKIP = false;
	
	
	@Override public boolean shouldSkipField(FieldAttributes f) {
		if (f.getName().equals("recordMode"))
			return SKIP;
		
		return DONT_SKIP;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return DONT_SKIP;
	}
}
