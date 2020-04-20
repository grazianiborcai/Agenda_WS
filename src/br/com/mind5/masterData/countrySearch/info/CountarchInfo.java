package br.com.mind5.masterData.countrySearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class CountarchInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	
	
	public CountarchInfo() {
		super();
	}
	
	
	
	public static CountarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountarchInfo.class);
	}
	
	
	
	public static List<CountarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountarchInfo.class);
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
		
		
		if (!(o instanceof CountarchInfo))
			return false;
		
		
		CountarchInfo obj = (CountarchInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry));
	}
}
