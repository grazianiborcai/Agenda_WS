package br.com.mind5.json.obsolete;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public final class JsonAttrExclusion implements ExclusionStrategy {
	private final boolean SKIP = true;
	private final boolean DONT_SKIP = false;
	
	
	@Override public boolean shouldSkipField(FieldAttributes f) {
		String fieldName = f.getName();
		
		if (fieldName == null)
			return DONT_SKIP;
		
		if (isTechnical(fieldName))
			return SKIP;
		
		if (isTime(fieldName))
			return SKIP;
		
		if (isPayment(fieldName))
			return SKIP;
		
		if (isInternalId(fieldName))
			return SKIP;
		
		return DONT_SKIP;
	}
	
	
	
	private boolean isTechnical(String fieldName) {
		if (fieldName.equals("recordMode"))
			return true;
		
		return false;
	}
	
	
	
	private boolean isTime(String fieldName) {
		if (fieldName.equals("second"))
			return true;
		
		if (fieldName.equals("nano"))
			return true;
		
		return false;
	}
	

	
	private boolean isPayment(String fieldName) {
		if (fieldName.equals("creditCardId"))
			return true;
		
		return false;
	}
	
	
	
	private boolean isInternalId(String fieldName) {
		if (fieldName.equals("customerId"))
			return true;
		
		return false;
	}
	
	
	
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return DONT_SKIP;
	}
}
