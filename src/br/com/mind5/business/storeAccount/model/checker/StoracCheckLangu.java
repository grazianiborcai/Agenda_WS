package br.com.mind5.business.storeAccount.model.checker;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class StoracCheckLangu extends ModelCheckerTemplateForward<StoracInfo, LanguInfo> {
	
	public StoracCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoracInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
