package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoCopierTemplate;

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
