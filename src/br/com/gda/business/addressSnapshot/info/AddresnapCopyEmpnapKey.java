package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class AddresnapCopyEmpnapKey extends InfoCopierTemplate<AddresnapInfo, EmpnapInfo>{
	
	public AddresnapCopyEmpnapKey() {
		super();
	}
	
	
	
	@Override protected AddresnapInfo makeCopyHook(EmpnapInfo source) {
		AddresnapInfo result = new AddresnapInfo();
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codEmployeeSnapshot = source.codSnapshot;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
