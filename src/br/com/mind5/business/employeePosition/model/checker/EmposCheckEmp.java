package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmposCheckEmp extends ModelCheckerTemplateForwardV2<EmposInfo, EmpInfo> {
	
	public EmposCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmposInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
