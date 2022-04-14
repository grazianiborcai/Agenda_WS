package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.checker.EmpwoutCheckExist;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public class StuntmCheckEmpwout extends ModelCheckerTemplateForward<StuntmInfo, EmpwoutInfo> {
	
	public StuntmCheckEmpwout(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpwoutInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwoutCheckExist(option);
	}
	
	
	
	@Override protected EmpwoutInfo toForwardClass(StuntmInfo baseRecord) {
		return EmpwoutInfo.copyFrom(baseRecord);
	}
}
