package br.com.mind5.business.phone.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PhoneSetterLChanged extends InfoSetterTemplate<PhoneInfo> {
	
	@Override protected PhoneInfo setAttrHook(PhoneInfo recordInfo) {
		
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
