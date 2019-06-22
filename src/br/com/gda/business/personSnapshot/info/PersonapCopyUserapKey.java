package br.com.gda.business.personSnapshot.info;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonapCopyUserapKey extends InfoCopierTemplate<PersonapInfo, UserapInfo>{
	
	public PersonapCopyUserapKey() {
		super();
	}
	
	
	
	@Override protected PersonapInfo makeCopyHook(UserapInfo source) {
		PersonapInfo result = new PersonapInfo();
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codSnapshot = source.codPersonSnapshot;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
