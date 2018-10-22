package br.com.gda.business.phone.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PhoneSetterNumber implements InfoSetter<PhoneInfo> {
	
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		checkArgument(recordInfo);
		
		if (hasAreaCode(recordInfo) == false)
			recordInfo = setAreaCode(recordInfo);
		
		return setNumber(recordInfo);
	}
	
		
	
	private void checkArgument(PhoneInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private boolean hasAreaCode(PhoneInfo recordInfo) {
		return (recordInfo.codArea > 0);
	}
	
	
	
	private PhoneInfo setAreaCode(PhoneInfo recordInfo) {
		PhoneSetterAreaCode setter = new PhoneSetterAreaCode();
		return setter.setAttr(recordInfo);
	}
	
	
	
	private PhoneInfo setNumber(PhoneInfo recordInfo) {
		recordInfo.number = recordInfo.phoneNumber;
		
		if (hasAreaCode(recordInfo)) {
			AreaPhone areaPhone = getAreaCode(recordInfo);
			int begin = areaPhone.getAreaCodeLength();
			int end = recordInfo.phoneNumber.length();
			
			recordInfo.number = recordInfo.phoneNumber.substring(begin, end);
		}		
		
		return recordInfo;
	}	
	
	
	
	private AreaPhone getAreaCode(PhoneInfo recordInfo) {
		return AreaPhone.getAreaPhone(recordInfo.codCountryPhone);
	}
}
