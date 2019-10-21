package br.com.mind5.business.personList.info;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersolisCopyOwnerap extends InfoCopierTemplate<PersolisInfo, OwnerapInfo>{
	
	public PersolisCopyOwnerap() {
		super();
	}
	
	
	
	@Override protected PersolisInfo makeCopyHook(OwnerapInfo source) {
		PersolisInfo result = new PersolisInfo();
		result.codOwner = source.codOwner;
		result.codPerson = source.codPerson;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
