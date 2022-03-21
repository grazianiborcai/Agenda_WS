package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterLockedOff extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		recordInfo.isLocked = false;		
		return recordInfo;
	}
}
