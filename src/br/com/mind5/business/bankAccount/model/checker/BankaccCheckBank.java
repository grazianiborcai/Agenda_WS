package br.com.mind5.business.bankAccount.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bank.model.checker.BankCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BankaccCheckBank extends ModelCheckerTemplateForward<BankaccInfo, BankInfo> {
	
	public BankaccCheckBank(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BankInfo> getCheckerHook(ModelCheckerOption option) {
		return new BankCheckExist(option);
	}
	
	
	
	@Override protected BankInfo toForwardClass(BankaccInfo baseRecord) {
		return BankInfo.copyFrom(baseRecord);
	}
}
