package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CountryPhoneInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String codCountry;
	public String txtCountry;
	public String codLanguage;
	
	
	public CountryPhoneInfo() {
		codLanguage = DefaultValue.language();
		codCountryPhone = DefaultValue.number();
	}
	
	
	
	public static CountryPhoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountryPhoneInfo.class);
	}
	
	
	
	public static List<CountryPhoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountryPhoneInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		return codCountryPhone;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CountryPhoneInfo))
			return false;
		
		
		CountryPhoneInfo obj = (CountryPhoneInfo) o;		
		return (codCountryPhone == obj.codCountryPhone);
	}
}
