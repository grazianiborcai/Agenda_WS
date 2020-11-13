package br.com.mind5.business.employeeLeaveDateSearch.model.checker;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplarchCheckLangu extends ModelCheckerTemplateForward<EmplarchInfo, LanguInfo> {
	
	public EmplarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(EmplarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
