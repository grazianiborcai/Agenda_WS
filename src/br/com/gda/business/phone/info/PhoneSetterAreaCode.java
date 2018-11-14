package br.com.gda.business.phone.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PhoneSetterAreaCode implements InfoSetter<PhoneInfo> {
	
	public PhoneInfo setAttr(PhoneInfo recordInfo) {
		checkArgument(recordInfo);
		AreaPhone areaPhone = getAreaCode(recordInfo);
		
		if (hasAreaCode(recordInfo, areaPhone))
			recordInfo.codArea = setAreaCode(recordInfo, areaPhone);
		
		
		return recordInfo;
	}
	
		
	
	private void checkArgument(PhoneInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private AreaPhone getAreaCode(PhoneInfo recordInfo) {
		return AreaPhone.getAreaPhone(recordInfo.codCountryPhone);
	}
	
	
	
	private boolean hasAreaCode(PhoneInfo recordInfo, AreaPhone areaPhone) {
		return (areaPhone.getAreaCodeLength() > 0);
	}
	
	
	
	private int setAreaCode(PhoneInfo recordInfo, AreaPhone areaPhone) {
		int begin = 0;
		int end = areaPhone.getAreaCodeLength();
		String areaCode = recordInfo.fullNumber.substring(begin, end);
		return Integer.valueOf(areaCode);
	}
}
