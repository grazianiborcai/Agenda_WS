package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmposCheckEmpwotarch extends ModelCheckerTemplateForwardV2<EmposInfo, EmpwotarchInfo> {
	
	public EmposCheckEmpwotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpwotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwotarchCheckExist(option);
	}
	
	
	
	@Override protected EmpwotarchInfo toForwardClass(EmposInfo baseRecord) {
		return EmpwotarchInfo.copyFrom(baseRecord);
	}
}
