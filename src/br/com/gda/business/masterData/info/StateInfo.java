package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class StateInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String codLanguage;
	
	
	public StateInfo() {
		this.codLanguage = DefaultValue.language();
	}
	
	
	
	public static StateInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StateInfo.class);
	}
	
	
	
	public static List<StateInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StateInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		return codCountry.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StateInfo))
			return false;
		
		
		StateInfo obj = (StateInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry) &&
				isStringEqual(codState, obj.codState));
	}
}
