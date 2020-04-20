package br.com.mind5.business.storeSearch.model.checker;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SotarchCheckLangu extends ModelCheckerTemplateForwardV2<SotarchInfo, LanguInfo> {
	
	public SotarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SotarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
