package br.com.mind5.business.storeList.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolisCopyOwner extends InfoCopierTemplate<StolisInfo, OwnerInfo> {
	
	public StolisCopyOwner() {
		super();
	}
	
	
	
	@Override protected StolisInfo makeCopyHook(OwnerInfo source) {
		StolisInfo result = new StolisInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
