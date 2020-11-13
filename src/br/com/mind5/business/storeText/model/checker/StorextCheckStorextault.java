package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StorextCheckStorextault extends ModelCheckerTemplateForward<StorextInfo, StorextaultInfo> {
	
	public StorextCheckStorextault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorextaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorextaultCheckExist(option);
	}
	
	
	
	@Override protected StorextaultInfo toForwardClass(StorextInfo baseRecord) {
		return StorextaultInfo.copyFrom(baseRecord);
	}
}
