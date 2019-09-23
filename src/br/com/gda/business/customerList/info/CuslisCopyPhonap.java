package br.com.gda.business.customerList.info;


import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CuslisCopyPhonap extends InfoCopierTemplate<CuslisInfo, PhonapInfo>{
	
	public CuslisCopyPhonap() {
		super();
	}
	
	
	
	@Override protected CuslisInfo makeCopyHook(PhonapInfo source) {
		CuslisInfo result = new CuslisInfo();
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;		
	}
}
