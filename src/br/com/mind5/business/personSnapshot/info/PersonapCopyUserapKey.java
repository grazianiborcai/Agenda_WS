package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class PersonapCopyUserapKey extends InfoCopierTemplate<PersonapInfo, UserapInfo> {
	
	public PersonapCopyUserapKey() {
		super();
	}
	
	
	
	@Override protected PersonapInfo makeCopyHook(UserapInfo source) {
		PersonapInfo result = new PersonapInfo();
		
		result.codOwner = source.codOwner;
		result.codSnapshot = source.codPersonSnapshot;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
