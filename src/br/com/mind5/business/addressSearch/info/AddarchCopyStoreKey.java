package br.com.mind5.business.addressSearch.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddarchCopyStoreKey extends InfoCopierTemplate<AddarchInfo, StoreInfo> {
	
	public AddarchCopyStoreKey() {
		super();
	}
	
	
	
	@Override protected AddarchInfo makeCopyHook(StoreInfo source) {
		AddarchInfo result = new AddarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
