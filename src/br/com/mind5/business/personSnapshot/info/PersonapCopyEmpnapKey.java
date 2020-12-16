package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonapCopyEmpnapKey extends InfoCopierTemplate<PersonapInfo, EmpnapInfo> {
	
	public PersonapCopyEmpnapKey() {
		super();
	}
	
	
	
	@Override protected PersonapInfo makeCopyHook(EmpnapInfo source) {
		PersonapInfo result = new PersonapInfo();
		
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codSnapshot = source.codPersonSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
