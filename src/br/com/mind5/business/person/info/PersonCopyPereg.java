package br.com.mind5.business.person.info;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonCopyPereg extends InfoCopierTemplate<PersonInfo, PeregInfo> {
	
	public PersonCopyPereg() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(PeregInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
