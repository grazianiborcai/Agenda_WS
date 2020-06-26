package br.com.mind5.business.store.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StoreCopyOwner extends InfoCopierTemplate<StoreInfo, OwnerInfo> {
	
	public StoreCopyOwner() {
		super();
	}
	
	
	
	@Override protected StoreInfo makeCopyHook(OwnerInfo source) {
		StoreInfo result = new StoreInfo();
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
