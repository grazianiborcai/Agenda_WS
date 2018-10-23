package br.com.gda.business.phone.info;

import br.com.gda.info.InfoSetter;

public final class PhoneSetterAll implements InfoSetter<PhoneInfo> {
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
		PhoneSetterAreaCode setterAreaCode = new PhoneSetterAreaCode();
		setterAreaCode.setAttr(recordInfo);
		
		PhoneSetterNumber setterNumber = new PhoneSetterNumber();
		setterNumber.setAttr(recordInfo);		
		
		return recordInfo;
	}
}
