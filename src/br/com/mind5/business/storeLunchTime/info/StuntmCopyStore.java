package br.com.mind5.business.storeLunchTime.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class StuntmCopyStore extends InfoCopierOneToManyTemplate<StuntmInfo, StoreInfo> {
	
	public StuntmCopyStore() {
		super();
	}
	
	
	
	@Override protected List<StuntmInfo> makeCopyHook(StoreInfo source) {
		return source.stuntmes;
	}
}
