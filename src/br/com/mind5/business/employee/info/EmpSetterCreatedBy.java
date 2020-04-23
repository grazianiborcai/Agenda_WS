package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterCreatedBy extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
