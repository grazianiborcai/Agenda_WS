package br.com.mind5.business.employeeLunchTimeConflict.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulocoInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpulocoCheckEmp extends ModelCheckerTemplateForward<EmpulocoInfo, EmpInfo> {
	
	public EmpulocoCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmpulocoInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
