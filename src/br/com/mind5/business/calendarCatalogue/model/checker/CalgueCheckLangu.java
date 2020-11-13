package br.com.mind5.business.calendarCatalogue.model.checker;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalgueCheckLangu extends ModelCheckerTemplateForward<CalgueInfo, LanguInfo> {
	
	public CalgueCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CalgueInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
