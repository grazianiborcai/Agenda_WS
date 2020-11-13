package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplateCheckLangu extends ModelCheckerTemplateForward<EmplateInfo, LanguInfo> {
	
	public EmplateCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmplateInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
