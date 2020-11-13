package br.com.mind5.business.orderList.model.checker;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdistCheckLangu extends ModelCheckerTemplateForward<OrdistInfo, LanguInfo> {
	
	public OrdistCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(OrdistInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
