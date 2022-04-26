package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.checker.EmplutmarchCheckExistEmpos;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmpCheckEmplutmarch extends ModelCheckerTemplateForward<EmpInfo, EmplutmarchInfo> {
	
	public EmpCheckEmplutmarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmplutmarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmplutmarchCheckExistEmpos(option);
	}
	
	
	
	@Override protected EmplutmarchInfo toForwardClass(EmpInfo baseRecord) {
		return EmplutmarchInfo.copyFrom(baseRecord);
	}
}
