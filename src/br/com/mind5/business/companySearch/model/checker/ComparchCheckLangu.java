package br.com.mind5.business.companySearch.model.checker;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class ComparchCheckLangu extends ModelCheckerTemplateForwardV2<ComparchInfo, LanguInfo> {
	
	public ComparchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(ComparchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
