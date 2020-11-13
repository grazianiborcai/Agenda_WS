package br.com.mind5.business.employeePositionSearch.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmposarchCheckLangu extends ModelCheckerTemplateForward<EmposarchInfo, LanguInfo> {
	
	public EmposarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmposarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
