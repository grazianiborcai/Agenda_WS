package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StorextCheckLangu extends ModelCheckerTemplateForward<StorextInfo, LanguInfo> {
	
	public StorextCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StorextInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
