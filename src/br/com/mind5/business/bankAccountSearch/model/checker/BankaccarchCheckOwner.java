package br.com.mind5.business.bankAccountSearch.model.checker;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BankaccarchCheckOwner extends ModelCheckerTemplateForward<BankaccarchInfo, OwnerInfo> {
	
	public BankaccarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(BankaccarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
