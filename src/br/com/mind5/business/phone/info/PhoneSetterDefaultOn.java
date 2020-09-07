package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PhoneSetterDefaultOn extends InfoSetterTemplate<PhoneInfo> {
	
	@Override protected PhoneInfo setAttrHook(PhoneInfo recordInfo) {	
		recordInfo.isDefault = true;
		return recordInfo;
	}
}
