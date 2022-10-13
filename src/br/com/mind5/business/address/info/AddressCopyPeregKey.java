package br.com.mind5.business.address.info;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyPeregKey extends InfoCopierTemplate<AddressInfo, PeregInfo> {
	
	public AddressCopyPeregKey() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(PeregInfo source) {
		AddressInfo result = new AddressInfo();
		
		result.codOwner = source.codOwner;
		result.codLegalPerson = source.codLegalPerson;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
