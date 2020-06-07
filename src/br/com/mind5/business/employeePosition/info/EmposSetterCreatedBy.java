package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmposSetterCreatedBy extends InfoSetterTemplate<EmposInfo> {
	
	@Override protected EmposInfo setAttrHook(EmposInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
