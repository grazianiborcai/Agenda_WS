package br.com.gda.business.person.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonCopyOwner extends InfoCopierTemplate<PersonInfo, OwnerInfo>{
	
	public PersonCopyOwner() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(OwnerInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		result.lastChangedBy = source.lastChangedBy;
		return result;
	}
}
