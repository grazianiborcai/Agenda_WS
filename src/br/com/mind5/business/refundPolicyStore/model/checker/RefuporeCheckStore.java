package br.com.mind5.business.refundPolicyStore.model.checker;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class RefuporeCheckStore extends ModelCheckerTemplateForward<RefuporeInfo, StoreInfo> {
	
	public RefuporeCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(RefuporeInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
