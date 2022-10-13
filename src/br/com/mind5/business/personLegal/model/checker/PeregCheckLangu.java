package br.com.mind5.business.personLegal.model.checker;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PeregCheckLangu extends ModelCheckerTemplateForward<PeregInfo, LanguInfo> {
	
	public PeregCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PeregInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
