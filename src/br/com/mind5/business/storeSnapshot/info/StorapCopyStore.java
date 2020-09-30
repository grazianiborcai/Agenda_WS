package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StorapCopyStore extends InfoCopierTemplate<StorapInfo, StoreInfo> {
	
	public StorapCopyStore() {
		super();
	}
	
	
	
	@Override protected StorapInfo makeCopyHook(StoreInfo source) {
		StorapInfo result = StorapInfo.copyFrom(source);
		result.storextsnapes = StorextsnapInfo.copyFrom(source.storextes);
		
		return result;
	}
}
