package br.com.gda.business.customerSearch.info;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CusarchCopyOrdnap extends InfoCopierTemplate<CusarchInfo, OrdnapInfo>{
	
	public CusarchCopyOrdnap() {
		super();
	}
	
	
	
	@Override protected CusarchInfo makeCopyHook(OrdnapInfo source) {
		CusarchInfo result = new CusarchInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;	
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
