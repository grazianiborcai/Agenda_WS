package br.com.mind5.business.employeeWorkTimeRange.model.checker;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpworgCheckStore extends ModelCheckerTemplateForward<EmpworgInfo, StoreInfo> {
	
	public EmpworgCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(EmpworgInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
