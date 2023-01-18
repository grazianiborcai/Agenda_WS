package br.com.mind5.business.bankAccount.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.masterData.bankHolderType.model.checker.BankoldypeCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BankaccCheckBankoldype extends ModelCheckerTemplateForward<BankaccInfo, BankoldypeInfo> {
	
	public BankaccCheckBankoldype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BankoldypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new BankoldypeCheckExist(option);
	}
	
	
	
	@Override protected BankoldypeInfo toForwardClass(BankaccInfo baseRecord) {
		return BankoldypeInfo.copyFrom(baseRecord);
	}
}
