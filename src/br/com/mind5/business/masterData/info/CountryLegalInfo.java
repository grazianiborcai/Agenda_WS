package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class CountryLegalInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	public String recordMode;
	
	
	public CountryLegalInfo() {
		super(CountryLegalInfo.class);
	}
	
	
	
	public static CountryLegalInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountryLegalInfo.class);
	}
	
	
	
	public static List<CountryLegalInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountryLegalInfo.class);
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
		
		
		if (!(o instanceof CountryLegalInfo))
			return false;
		
		
		CountryLegalInfo obj = (CountryLegalInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry));
	}
}
