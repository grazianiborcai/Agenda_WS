package br.com.mind5.business.employeeLunchTimeRange.model.checker;

import br.com.mind5.business.employeeLunchTimeRange.info.EmpulranInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpulranCheckLangu extends ModelCheckerTemplateForward<EmpulranInfo, LanguInfo> {
	
	public EmpulranCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmpulranInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
