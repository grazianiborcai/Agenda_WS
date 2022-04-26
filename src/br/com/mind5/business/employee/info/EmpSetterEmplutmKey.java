package br.com.mind5.business.employee.info;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterEmplutmKey extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		for (EmplutmInfo eachEmplutm : recordInfo.emplutmes) {
			eachEmplutm.codOwner = recordInfo.codOwner;
			eachEmplutm.codStore = recordInfo.codStore;
			eachEmplutm.codEmployee = recordInfo.codEmployee;
			eachEmplutm.username = recordInfo.username;
			eachEmplutm.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
}
