package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhonapCopyEmpnapKey extends InfoCopierTemplate<PhonapInfo, EmpnapInfo>{
	
	public PhonapCopyEmpnapKey() {
		super();
	}
	
	
	
	@Override protected PhonapInfo makeCopyHook(EmpnapInfo source) {
		PhonapInfo result = new PhonapInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codEmployeeSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
