package br.com.gda.payment.masterDataPartner.moip.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhomoipInfo extends InfoRecord implements Cloneable {
	public String countryCode;
	public String areaCode;
	public int number;
	
	
	
	public PhomoipInfo() {
		number = DefaultValue.number();
	}
	
	
	
	public static PhomoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhomoipInfo.class);
	}
	
	
	
	public static List<PhomoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhomoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhomoipInfo))
			return false;
		
		
		PhomoipInfo obj = (PhomoipInfo) o;
		return (isStringEqual(obj.countryCode, this.countryCode) 	&&
				isStringEqual(obj.areaCode, this.areaCode)			&&
				obj.number == this.number								);
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (countryCode != null)
			result = result * 31 + countryCode.hashCode();
		
		if (areaCode != null)
			result = result * 31 + areaCode.hashCode();
		
		result = result * 31 + number;
		
		return result;
	}
}
