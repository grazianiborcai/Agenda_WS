package br.com.mind5.business.bankAccountSnapshot.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckExist;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BankaccnapCheckBankacc extends ModelCheckerTemplateForward<BankaccnapInfo, BankaccInfo> {
	
	public BankaccnapCheckBankacc(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BankaccInfo> getCheckerHook(ModelCheckerOption option) {
		return new BankaccCheckExist(option);
	}
	
	
	
	@Override protected BankaccInfo toForwardClass(BankaccnapInfo baseRecord) {
		return BankaccInfo.copyFrom(baseRecord);
	}
}
