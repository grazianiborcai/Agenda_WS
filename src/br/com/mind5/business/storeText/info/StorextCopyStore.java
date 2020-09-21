package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StorextCopyStore extends InfoCopierOneToManyTemplate<StorextInfo, StoreInfo> {
	
	public StorextCopyStore() {
		super();
	}
	
	
	
	@Override protected List<StorextInfo> makeCopyHook(StoreInfo source) {
		return source.matextes;
	}
}
