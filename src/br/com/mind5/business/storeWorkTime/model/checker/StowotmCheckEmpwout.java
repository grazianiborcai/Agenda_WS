package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckExist;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public class StowotmCheckEmpwout extends ModelCheckerTemplateForward<StowotmInfo, EmpwoutInfo> {
	
	public StowotmCheckEmpwout(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpwoutInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwoutCheckExist(option);
	}
	
	
	
	@Override protected EmpwoutInfo toForwardClass(StowotmInfo baseRecord) {
		return EmpwoutInfo.copyFrom(baseRecord);
	}
}
