package br.com.mind5.payment.countryPartner.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CounparInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public int codPayPartner;
	public boolean isDefault;
	public String txtPayPartner;
	public String description;
	
	
	public CounparInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
		isDefault = DefaultValue.boole();
	}
	
	
	
	public static CounparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CounparInfo.class);
	}
	
	
	
	public static List<CounparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CounparInfo.class);
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
		
		
		if (!(o instanceof CounparInfo))
			return false;
		
		
		CounparInfo obj = (CounparInfo) o;		
		return (isStringEqual(codCountry, obj.codCountry) && codPayPartner == obj.codPayPartner);
	}
}
