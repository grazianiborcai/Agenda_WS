package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhoneInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String phoneNumber;
	public int codArea;
	public String number;
	public String formatted;
	
	
	public PhoneInfo() {
		codCountryPhone = DefaultValue.number();
		codArea = DefaultValue.number();
	}
	
	
	
	public static PhoneInfo copyFrom(Object sourceObj) {
		PhoneInfo result = copyFrom(sourceObj, PhoneInfo.class);
		return setAttr(result);
	}
	
	
	
	public static List<PhoneInfo> copyFrom(List<?> sourceObjs) {
		List<PhoneInfo> results = copyFrom(sourceObjs, PhoneInfo.class);
		
		for (PhoneInfo eachPhone : results) {
			setAttr(eachPhone);
		}
		
		return results;
	}
	
	
	
	private static PhoneInfo setAttr(PhoneInfo recordInfo) {		
		PhoneSetterAll setterAttr = new PhoneSetterAll();
		setterAttr.setAttr(recordInfo);
		
		return recordInfo;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codCountryPhone ^ (codCountryPhone >>> 32));
		
		if (phoneNumber != null)
			result = result * 31 + phoneNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhoneInfo))
			return false;
		
		
		PhoneInfo obj = (PhoneInfo) o;		
		return (codCountryPhone == obj.codCountryPhone && isStringEqual(phoneNumber, obj.phoneNumber));
	}	
}
