package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayparCountryInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	
	
	public PayparCountryInfo() {
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayparCountryInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayparCountryInfo.class);
	}
	
	
	
	public static List<PayparCountryInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayparCountryInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codCountry != null)		
			result = result * 31 + codCountry.hashCode();
		
		result = result * 31 + codPayPartner;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayparCountryInfo))
			return false;
		
		
		PayparCountryInfo obj = (PayparCountryInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry) && codPayPartner == obj.codPayPartner);
	}
}
