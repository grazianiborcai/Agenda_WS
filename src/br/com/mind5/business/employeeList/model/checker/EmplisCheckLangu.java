package br.com.mind5.business.employeeList.model.checker;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplisCheckLangu extends ModelCheckerTemplateForward<EmplisInfo, LanguInfo> {
	
	public EmplisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmplisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
