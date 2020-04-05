package br.com.mind5.business.address.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class AddressSetterLChanged extends InfoSetterTemplate<AddressInfo> {
	
	@Override protected AddressInfo setAttrHook(AddressInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
