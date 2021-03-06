package br.com.mind5.business.orderSearch.model.checker;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdarchCheckLangu extends ModelCheckerTemplateForward<OrdarchInfo, LanguInfo> {
	
	public OrdarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(OrdarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
