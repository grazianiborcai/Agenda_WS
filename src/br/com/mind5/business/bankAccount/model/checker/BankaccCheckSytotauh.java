package br.com.mind5.business.bankAccount.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BankaccCheckSytotauh extends ModelCheckerTemplateForward<BankaccInfo, SytotauhInfo> {
	
	public BankaccCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(BankaccInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
