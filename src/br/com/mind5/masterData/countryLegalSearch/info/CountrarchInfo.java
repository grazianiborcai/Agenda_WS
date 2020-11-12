package br.com.mind5.masterData.countryLegalSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class CountrarchInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	public String recordMode;
	
	
	public CountrarchInfo() {
		super();
	}
	
	
	
	public static CountrarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountrarchInfo.class);
	}
	
	
	
	public static List<CountrarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountrarchInfo.class);
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
		
		
		if (!(o instanceof CountrarchInfo))
			return false;
		
		
		CountrarchInfo obj = (CountrarchInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry));
	}
}
