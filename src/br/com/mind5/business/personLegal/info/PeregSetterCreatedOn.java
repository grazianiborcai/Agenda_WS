package br.com.mind5.business.personLegal.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PeregSetterCreatedOn extends InfoSetterTemplate<PeregInfo> {
	
	@Override protected PeregInfo setAttrHook(PeregInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
