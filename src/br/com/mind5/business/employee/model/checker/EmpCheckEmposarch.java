package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeePositionSearch.info.EmposarchCopier;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpCheckEmposarch extends ModelCheckerTemplateForward<EmpInfo, EmposarchInfo> {
	
	public EmpCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(EmpInfo baseRecord) {
		return EmposarchCopier.copyFromEmp(baseRecord);
	}
}
