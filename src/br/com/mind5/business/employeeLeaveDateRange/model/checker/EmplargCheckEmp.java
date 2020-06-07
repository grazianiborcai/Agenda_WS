package br.com.mind5.business.employeeLeaveDateRange.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmplargCheckEmp extends ModelCheckerTemplateForwardV2<EmplargInfo, EmpInfo> {
	
	public EmplargCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmplargInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
