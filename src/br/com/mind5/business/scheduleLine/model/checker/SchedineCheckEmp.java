package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedineCheckEmp extends ModelCheckerTemplateForward<SchedineInfo, EmpInfo> {
	
	public SchedineCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(SchedineInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
