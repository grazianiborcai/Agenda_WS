package br.com.mind5.business.employeePosition.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmposSetterCreatedOn extends InfoSetterTemplate<EmposInfo> {
	
	@Override protected EmposInfo setAttrHook(EmposInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}	
}
