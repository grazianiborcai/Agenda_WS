package br.com.mind5.business.customerList.model.checker;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CuslisCheckLangu extends ModelCheckerTemplateForward<CuslisInfo, LanguInfo> {
	
	public CuslisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CuslisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
