package br.com.mind5.business.materialStore.info;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatoreCopyStore extends InfoCopierOneToManyTemplate<MatoreInfo, StoreInfo>{
	
	public MatoreCopyStore() {
		super();
	}
	
	
	
	@Override protected List<MatoreInfo> makeCopyHook(StoreInfo source) {
		return source.matores;
	}
}
