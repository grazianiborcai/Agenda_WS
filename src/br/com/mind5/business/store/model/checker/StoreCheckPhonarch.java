package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckExistStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class StoreCheckPhonarch extends ModelCheckerTemplateForward<StoreInfo, PhonarchInfo> {
	
	public StoreCheckPhonarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonarchCheckExistStore(option);
	}
	
	
	
	@Override protected PhonarchInfo toForwardClass(StoreInfo baseRecord) {
		return PhonarchInfo.copyFrom(baseRecord);
	}
}
