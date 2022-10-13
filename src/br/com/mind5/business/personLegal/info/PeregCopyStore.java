package br.com.mind5.business.personLegal.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PeregCopyStore extends InfoCopierTemplate<PeregInfo, StoreInfo> {
	
	public PeregCopyStore() {
		super();
	}
	
	
	
	@Override protected PeregInfo makeCopyHook(StoreInfo source) {
		PeregInfo result = PeregInfo.copyFrom(source.peregData);
		return result;
	}
}
