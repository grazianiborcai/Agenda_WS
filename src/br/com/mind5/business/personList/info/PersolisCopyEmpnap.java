package br.com.mind5.business.personList.info;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersolisCopyEmpnap extends InfoCopierTemplate<PersolisInfo, EmpnapInfo>{
	
	public PersolisCopyEmpnap() {
		super();
	}
	
	
	
	@Override protected PersolisInfo makeCopyHook(EmpnapInfo source) {
		PersolisInfo result = new PersolisInfo();
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
