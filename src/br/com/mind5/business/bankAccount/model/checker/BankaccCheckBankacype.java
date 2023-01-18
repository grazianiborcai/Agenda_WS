package br.com.mind5.business.bankAccount.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankAccountType.model.checker.BankacypeCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BankaccCheckBankacype extends ModelCheckerTemplateForward<BankaccInfo, BankacypeInfo> {
	
	public BankaccCheckBankacype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BankacypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new BankacypeCheckExist(option);
	}
	
	
	
	@Override protected BankacypeInfo toForwardClass(BankaccInfo baseRecord) {
		return BankacypeInfo.copyFrom(baseRecord);
	}
}
