package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatextCheckStorextault extends ModelCheckerTemplateForwardV2<StorextInfo, StorextaultInfo> {
	
	public MatextCheckStorextault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorextaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorextaultCheckExist(option);
	}
	
	
	
	@Override protected StorextaultInfo toForwardClass(StorextInfo baseRecord) {
		return StorextaultInfo.copyFrom(baseRecord);
	}
}
