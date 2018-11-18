package br.com.gda.business.phone.info;

import br.com.gda.info.InfoSetter;

public final class PhoneSetterAll_ implements InfoSetter<PhoneInfo> {
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		PhoneInfo result = recordInfo;
		
		if (checkMandatoryField(recordInfo))
			result = setAllAttr(result);
		
		return result;
	}
	
	
	
	private boolean checkMandatoryField(PhoneInfo recordInfo) {
		return (recordInfo.codCountryPhone > 0);
	}
	
	
	
	private PhoneInfo setAllAttr(PhoneInfo recordInfo) {
		PhoneSetterAreaCode_ setterAreaCode = new PhoneSetterAreaCode_();
		setterAreaCode.setAttr(recordInfo);
		
		PhoneSetterNumber_ setterNumber = new PhoneSetterNumber_();
		setterNumber.setAttr(recordInfo);		
		
		return recordInfo;
	}
}
