package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpwotmCheckStowotarch extends ModelCheckerTemplateForwardV2<EmpwotmInfo, StowotarchInfo> {
	
	public EmpwotmCheckStowotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StowotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StowotarchCheckExist(option);
	}
	
	
	
	@Override protected StowotarchInfo toForwardClass(EmpwotmInfo baseRecord) {
		return StowotarchInfo.copyFrom(baseRecord);
	}
}
