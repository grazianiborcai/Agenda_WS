package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CusCheckLangu extends ModelCheckerTemplateForward<CusInfo, LanguInfo> {
	
	public CusCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CusInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
