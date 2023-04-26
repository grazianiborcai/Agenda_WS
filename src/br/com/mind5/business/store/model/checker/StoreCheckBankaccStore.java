package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckExistStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class StoreCheckBankaccStore extends ModelCheckerTemplateForward<StoreInfo, BankaccInfo> {
	
	public StoreCheckBankaccStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BankaccInfo> getCheckerHook(ModelCheckerOption option) {
		return new BankaccCheckExistStore(option);
	}
	
	
	
	@Override protected BankaccInfo toForwardClass(StoreInfo baseRecord) {
		return BankaccInfo.copyFrom(baseRecord);
	}
}
