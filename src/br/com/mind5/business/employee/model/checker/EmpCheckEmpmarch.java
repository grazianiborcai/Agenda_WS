package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpCheckEmpmarch extends ModelCheckerTemplateForward<EmpInfo, EmpmarchInfo> {
	
	public EmpCheckEmpmarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpmarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmarchCheckExist(option);
	}
	
	
	
	@Override protected EmpmarchInfo toForwardClass(EmpInfo baseRecord) {
		return EmpmarchInfo.copyFrom(baseRecord);
	}
}
