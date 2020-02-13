package br.com.mind5.payment.countryPartnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CounparchInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public int codPayPartner;
	public boolean isDefault;
	
	
	public CounparchInfo() {
		super(CounparchInfo.class);
		
		codPayPartner = DefaultValue.number();
		isDefault = DefaultValue.boole();
	}
	
	
	
	public static CounparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CounparchInfo.class);
	}
	
	
	
	public static List<CounparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CounparchInfo.class);
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
		
		
		if (!(o instanceof CounparchInfo))
			return false;
		
		
		CounparchInfo obj = (CounparchInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry) && codPayPartner == obj.codPayPartner);
	}
}
