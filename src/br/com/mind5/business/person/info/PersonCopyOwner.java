package br.com.mind5.business.person.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonCopyOwner extends InfoCopierTemplate<PersonInfo, OwnerInfo> {
	
	public PersonCopyOwner() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(OwnerInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		result.username = source.username;
		return result;
	}
}
