package br.com.mind5.business.employeeWorkTimeOutlier.model.checker;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpwoutCheckStore extends ModelCheckerTemplateForwardV2<EmpwoutInfo, StoreInfo> {
	
	public EmpwoutCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(EmpwoutInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
