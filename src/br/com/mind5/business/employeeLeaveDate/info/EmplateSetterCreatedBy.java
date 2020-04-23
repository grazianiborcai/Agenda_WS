package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplateSetterCreatedBy extends InfoSetterTemplate<EmplateInfo> {
	
	@Override protected EmplateInfo setAttrHook(EmplateInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
