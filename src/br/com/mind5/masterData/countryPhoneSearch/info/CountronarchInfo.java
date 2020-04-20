package br.com.mind5.masterData.countryPhoneSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CountronarchInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String codCountry;
	public String txtCountry;
	
	
	public CountronarchInfo() {
		super();
		
		codCountryPhone = DefaultValue.number();
	}
	
	
	
	public static CountronarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountronarchInfo.class);
	}
	
	
	
	public static List<CountronarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountronarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		result = result * 31 + codCountryPhone;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CountronarchInfo))
			return false;
		
		
		CountronarchInfo obj = (CountronarchInfo) o;		
		return (codCountryPhone == obj.codCountryPhone);
	}
}
