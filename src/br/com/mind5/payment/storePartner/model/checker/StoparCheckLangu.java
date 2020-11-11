package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckLangu extends ModelCheckerTemplateForwardV2<StoparInfo, LanguInfo> {
	
	public StoparCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoparInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
