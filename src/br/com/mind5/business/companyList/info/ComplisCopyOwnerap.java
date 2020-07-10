package br.com.mind5.business.companyList.info;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class ComplisCopyOwnerap extends InfoCopierTemplate<ComplisInfo, OwnerapInfo> {
	
	public ComplisCopyOwnerap() {
		super();
	}
	
	
	
	@Override protected ComplisInfo makeCopyHook(OwnerapInfo source) {
		ComplisInfo result = new ComplisInfo();
		result.codOwner = source.codOwner;
		result.codCompany = source.codCompany;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
