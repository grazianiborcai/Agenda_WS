package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpwotmCheckEmposarch extends ModelCheckerTemplateForward<EmpwotmInfo, EmposarchInfo> {
	
	public EmpwotmCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(EmpwotmInfo baseRecord) {
		return EmposarchInfo.copyFrom(baseRecord);
	}
}
