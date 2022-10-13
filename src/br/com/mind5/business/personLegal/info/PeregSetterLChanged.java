package br.com.mind5.business.personLegal.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PeregSetterLChanged extends InfoSetterTemplate<PeregInfo> {
	
	@Override protected PeregInfo setAttrHook(PeregInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
