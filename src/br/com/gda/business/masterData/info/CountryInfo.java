package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CountryInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	public String codLanguage;
	
	
	public CountryInfo() {
		super(CountryInfo.class);
		
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static CountryInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountryInfo.class);
	}
	
	
	
	public static List<CountryInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountryInfo.class);
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
		
		
		if (!(o instanceof CountryInfo))
			return false;
		
		
		CountryInfo obj = (CountryInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry));
	}
}
