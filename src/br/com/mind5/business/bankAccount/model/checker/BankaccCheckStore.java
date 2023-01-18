package br.com.mind5.business.bankAccount.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BankaccCheckStore extends ModelCheckerTemplateForward<BankaccInfo, StoreInfo> {
	
	public BankaccCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(BankaccInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
