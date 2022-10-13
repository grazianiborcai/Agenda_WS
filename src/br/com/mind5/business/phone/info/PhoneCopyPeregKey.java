package br.com.mind5.business.phone.info;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyPeregKey extends InfoCopierTemplate<PhoneInfo, PeregInfo> {
	
	public PhoneCopyPeregKey() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(PeregInfo source) {
		PhoneInfo result = new PhoneInfo();
		
		result.codOwner = source.codOwner;
		result.codLegalPerson = source.codLegalPerson;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
