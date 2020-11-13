package br.com.mind5.business.storeText.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StorextCheckStore extends ModelCheckerTemplateForward<StorextInfo, StoreInfo> {

	public StorextCheckStore(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(StorextInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
