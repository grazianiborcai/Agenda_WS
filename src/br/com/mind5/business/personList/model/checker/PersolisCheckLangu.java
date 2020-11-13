package br.com.mind5.business.personList.model.checker;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PersolisCheckLangu extends ModelCheckerTemplateForward<PersolisInfo, LanguInfo> {
	
	public PersolisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PersolisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
