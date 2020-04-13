package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhoneSetterNumberT00 extends InfoSetterTemplate<PhoneInfo> {
	
	@Override protected PhoneInfo setAttrHook(PhoneInfo recordInfo) {
		recordInfo.number = recordInfo.fullNumber;
		return recordInfo;
	}	
}
