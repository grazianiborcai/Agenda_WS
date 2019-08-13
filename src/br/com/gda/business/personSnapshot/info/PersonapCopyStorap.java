package br.com.gda.business.personSnapshot.info;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonapCopyStorap extends InfoCopierTemplate<PersonapInfo, StorapInfo>{
	
	public PersonapCopyStorap() {
		super();
	}
	
	
	
	@Override protected PersonapInfo makeCopyHook(StorapInfo source) {
		PersonapInfo result = new PersonapInfo();
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.codSnapshot = source.codPersonSnapshot;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
