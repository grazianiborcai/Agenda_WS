package br.com.mind5.business.bankAccount.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BankaccCheckOwner extends ModelCheckerTemplateForward<BankaccInfo, OwnerInfo> {
	
	public BankaccCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(BankaccInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
