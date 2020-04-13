package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhoneSetterNumberT01 extends InfoSetterTemplate<PhoneInfo> {
	
	@Override protected PhoneInfo setAttrHook(PhoneInfo recordInfo) {		
		if (hasArea(recordInfo) == false)
			recordInfo = setArea(recordInfo);
		
		return setNumber(recordInfo);
	}
	
	
	
	private boolean hasArea(PhoneInfo recordInfo) {
		return (recordInfo.codArea != null);
	}
	
	
	
	private PhoneInfo setArea(PhoneInfo recordInfo) {
		PhoneSetterAreaT01 setter = new PhoneSetterAreaT01();
		return setter.setAttr(recordInfo);
	}
	
	
	
	private PhoneInfo setNumber(PhoneInfo recordInfo) {
		recordInfo.number = recordInfo.fullNumber;
		
		if (hasArea(recordInfo)) {
			int begin = getAreaLength(recordInfo);
			int end = recordInfo.fullNumber.length();
			
			recordInfo.number = recordInfo.fullNumber.substring(begin, end);
		}		
		
		return recordInfo;
	}	
	
	
	
	private int getAreaLength(PhoneInfo recordInfo) {
		return recordInfo.codArea.length();
	}
}
