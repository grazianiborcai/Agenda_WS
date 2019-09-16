package br.com.gda.business.personList.info;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.info.InfoCopierTemplate;

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
