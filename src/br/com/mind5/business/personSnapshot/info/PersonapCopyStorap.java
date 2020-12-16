package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonapCopyStorap extends InfoCopierTemplate<PersonapInfo, StorapInfo> {
	
	public PersonapCopyStorap() {
		super();
	}
	
	
	
	@Override protected PersonapInfo makeCopyHook(StorapInfo source) {
		PersonapInfo result = new PersonapInfo();
		
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codSnapshot = source.codPersonSnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
