package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpwocoCheckEmp extends ModelCheckerTemplateForwardV2<EmpwocoInfo, EmpInfo> {
	
	public EmpwocoCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmpwocoInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
