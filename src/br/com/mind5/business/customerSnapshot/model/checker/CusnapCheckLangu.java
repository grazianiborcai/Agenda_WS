package br.com.mind5.business.customerSnapshot.model.checker;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CusnapCheckLangu extends ModelCheckerTemplateForwardV2<CusnapInfo, LanguInfo> {
	
	public CusnapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CusnapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
