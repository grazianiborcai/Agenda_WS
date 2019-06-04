package br.com.gda.business.personSnapshot.info;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonapCopyEmpnapKey extends InfoCopierTemplate<PersonapInfo, EmpnapInfo>{
	
	public PersonapCopyEmpnapKey() {
		super();
	}
	
	
	
	@Override protected PersonapInfo makeCopyHook(EmpnapInfo source) {
		PersonapInfo result = new PersonapInfo();
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codSnapshot = source.codPersonSnapshot;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
