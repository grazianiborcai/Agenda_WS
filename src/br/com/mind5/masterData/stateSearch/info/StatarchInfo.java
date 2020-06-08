package br.com.mind5.masterData.stateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class StatarchInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String txtCountry;
	public String codCountryAlpha3;
	public String codState;
	public String txtState;
	
	
	public StatarchInfo() {
		super();
	}
	
	
	
	public static StatarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StatarchInfo.class);
	}
	
	
	
	public static List<StatarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StatarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codCountry == null)
			return 0;
		
		return codCountry.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StatarchInfo))
			return false;
		
		
		StatarchInfo obj = (StatarchInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry) &&
				isStringEqual(codState, obj.codState));
	}
}
