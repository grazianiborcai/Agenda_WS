package br.com.mind5.business.companySnapshot.info;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CompnapCopyStorap extends InfoCopierTemplate<CompnapInfo, StorapInfo>{
	
	public CompnapCopyStorap() {
		super();
	}
	
	
	
	@Override protected CompnapInfo makeCopyHook(StorapInfo source) {
		CompnapInfo result = new CompnapInfo();
		result.codOwner = source.codOwner;
		result.codCompany = source.codCompany;
		result.codSnapshot = source.codCompanySnapshot;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
