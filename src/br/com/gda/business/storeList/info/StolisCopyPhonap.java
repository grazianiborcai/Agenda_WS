package br.com.gda.business.storeList.info;


import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class StolisCopyPhonap extends InfoCopierTemplate<StolisInfo, PhonapInfo>{
	
	public StolisCopyPhonap() {
		super();
	}
	
	
	
	@Override protected StolisInfo makeCopyHook(PhonapInfo source) {
		StolisInfo result = new StolisInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
