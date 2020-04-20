package br.com.mind5.masterData.countryPhone.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CountroneInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String codCountry;
	public String txtCountry;
	
	
	public CountroneInfo() {
		super();
		
		codCountryPhone = DefaultValue.number();
	}
	
	
	
	public static CountroneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountroneInfo.class);
	}
	
	
	
	public static List<CountroneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountroneInfo.class);
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
		
		
		if (!(o instanceof CountroneInfo))
			return false;
		
		
		CountroneInfo obj = (CountroneInfo) o;		
		return (codCountryPhone == obj.codCountryPhone);
	}
}
