package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StowotmCopyStore extends InfoCopierOneToManyTemplate<StowotmInfo, StoreInfo> {
	
	public StowotmCopyStore() {
		super();
	}
	
	
	
	@Override protected List<StowotmInfo> makeCopyHook(StoreInfo source) {
		return source.stowotmes;
	}
}
