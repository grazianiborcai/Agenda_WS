package br.com.gda.business.company.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CompCopyStore extends InfoCopierTemplate<CompInfo, StoreInfo>{
	
	public CompCopyStore() {
		super();
	}
	
	
	
	@Override protected CompInfo makeCopyHook(StoreInfo source) {
		CompInfo result = CompInfo.copyFrom(source.companyData);
		return result;
	}
}
