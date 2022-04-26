package br.com.mind5.business.employee.info;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterEmpwotmKey extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		for (EmpwotmInfo eachEmpwotm : recordInfo.empwotmes) {
			eachEmpwotm.codOwner = recordInfo.codOwner;
			eachEmpwotm.codStore = recordInfo.codStore;
			eachEmpwotm.codEmployee = recordInfo.codEmployee;
			eachEmpwotm.username = recordInfo.username;
			eachEmpwotm.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
