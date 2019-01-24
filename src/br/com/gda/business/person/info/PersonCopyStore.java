package br.com.gda.business.person.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonCopyStore extends InfoCopierTemplate<PersonInfo, StoreInfo>{
	
	public PersonCopyStore() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(StoreInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
