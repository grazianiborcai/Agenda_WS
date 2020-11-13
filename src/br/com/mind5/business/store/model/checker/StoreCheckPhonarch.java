package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoreCheckPhonarch extends ModelCheckerTemplateForward<StoreInfo, PhonarchInfo> {
	
	public StoreCheckPhonarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonarchCheckExist(option);
	}
	
	
	
	@Override protected PhonarchInfo toForwardClass(StoreInfo baseRecord) {
		return PhonarchCopier.copyFromStore(baseRecord);
	}
}
