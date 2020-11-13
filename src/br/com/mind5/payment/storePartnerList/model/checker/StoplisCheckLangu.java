package br.com.mind5.payment.storePartnerList.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisCheckLangu extends ModelCheckerTemplateForward<StoplisInfo, LanguInfo> {
	
	public StoplisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoplisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
