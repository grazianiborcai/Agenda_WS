package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterLockedOn extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		recordInfo.isLocked = true;		
		return recordInfo;
	}
}
