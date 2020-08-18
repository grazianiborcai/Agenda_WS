package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpmatSetterCreatedBy extends InfoSetterTemplate<EmpmatInfo> {
	
	@Override protected EmpmatInfo setAttrHook(EmpmatInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
