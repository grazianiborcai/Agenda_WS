package br.com.mind5.masterData.countryLegal.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class CountralInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	public String recordMode;
	
	
	public CountralInfo() {
		super();
	}
	
	
	
	public static CountralInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountralInfo.class);
	}
	
	
	
	public static List<CountralInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountralInfo.class);
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
		
		
		if (!(o instanceof CountralInfo))
			return false;
		
		
		CountralInfo obj = (CountralInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry));
	}
}
