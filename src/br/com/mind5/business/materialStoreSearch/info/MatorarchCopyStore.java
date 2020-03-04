package br.com.mind5.business.materialStoreSearch.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MatorarchCopyStore extends InfoCopierTemplate<MatorarchInfo, StoreInfo>{
	
	public MatorarchCopyStore() {
		super();
	}
	
	
	
	@Override protected MatorarchInfo makeCopyHook(StoreInfo source) {
		MatorarchInfo result = new MatorarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
