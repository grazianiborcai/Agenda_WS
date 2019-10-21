package br.com.mind5.business.company.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CompCopyStore extends InfoCopierTemplate<CompInfo, StoreInfo>{
	
	public CompCopyStore() {
		super();
	}
	
	
	
	@Override protected CompInfo makeCopyHook(StoreInfo source) {
		CompInfo result = CompInfo.copyFrom(source.companyData);
		return result;
	}
}
