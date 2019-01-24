package br.com.gda.payPartner.moip.moipMasterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhoneInfo extends InfoRecord implements Cloneable {
	public String countryCode;
	public String areaCode;
	public int number;
	
	
	
	public PhoneInfo() {
		number = DefaultValue.number();
	}
	
	
	
	public static PhoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhoneInfo.class);
	}
	
	
	
	public static List<PhoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhoneInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhoneInfo))
			return false;
		
		
		PhoneInfo obj = (PhoneInfo) o;
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
