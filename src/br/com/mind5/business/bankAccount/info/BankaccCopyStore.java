package br.com.mind5.business.bankAccount.info;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class BankaccCopyStore extends InfoCopierTemplate<BankaccInfo, StoreInfo> {
	
	public BankaccCopyStore() {
		super();
	}
	
	
	
	@Override protected BankaccInfo makeCopyHook(StoreInfo source) {
		return source.bankaccData;
	}
}
