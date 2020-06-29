package br.com.mind5.business.person.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonCopyStore extends InfoCopierTemplate<PersonInfo, StoreInfo> {
	
	public PersonCopyStore() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(StoreInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
