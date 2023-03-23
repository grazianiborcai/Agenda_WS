package br.com.mind5.payment.creditCardSearch.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchCheckLangu extends ModelCheckerTemplateForward<CrecarchInfo, LanguInfo> {
	
	public CrecarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CrecarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
