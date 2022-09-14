package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpwotmSetterIsDeletedOn extends InfoSetterTemplate<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo setAttrHook(EmpwotmInfo recordInfo) {
		recordInfo.isDeleted = true;
		return recordInfo;
	}
}
