package br.com.gda.business.store.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierTemplate;

final class StoreCopyOwner extends InfoCopierTemplate<StoreInfo, OwnerInfo>{
	
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
