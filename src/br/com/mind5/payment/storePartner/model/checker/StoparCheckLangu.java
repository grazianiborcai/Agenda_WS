package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckLangu extends ModelCheckerTemplateForward<StoparInfo, LanguInfo> {
	
	public StoparCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoparInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
