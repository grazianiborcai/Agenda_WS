package br.com.mind5.business.employeeLunchTimeRange.model.checker;

import br.com.mind5.business.employeeLunchTimeRange.info.EmpulranInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpulranCheckStore extends ModelCheckerTemplateForward<EmpulranInfo, StoreInfo> {
	
	public EmpulranCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(EmpulranInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
