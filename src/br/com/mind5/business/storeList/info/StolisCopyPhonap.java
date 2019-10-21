package br.com.mind5.business.storeList.info;


import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
