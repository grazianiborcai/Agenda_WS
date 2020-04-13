package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhoneSetterAreaT01 extends InfoSetterTemplate<PhoneInfo> {
	private final int AREA_LENGTH = 2;
	
	@Override protected PhoneInfo setAttrHook(PhoneInfo recordInfo) {
		recordInfo.codArea = getArea(recordInfo);				
		return recordInfo;
	}
	
	
	
	private String getArea(PhoneInfo recordInfo) {
		int begin = 0;
		int end = AREA_LENGTH;
		return recordInfo.fullNumber.substring(begin, end);
	}
}
