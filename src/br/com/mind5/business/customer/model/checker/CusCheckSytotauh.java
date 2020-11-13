package br.com.mind5.business.customer.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckExist;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CusCheckSytotauh extends ModelCheckerTemplateForward<CusInfo, SytotauhInfo> {
	
	public CusCheckSytotauh(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotauhInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotauhCheckExist(option);
	}
	
	
	
	@Override protected SytotauhInfo toForwardClass(CusInfo baseRecord) {
		return SytotauhInfo.copyFrom(baseRecord);
	}
}
