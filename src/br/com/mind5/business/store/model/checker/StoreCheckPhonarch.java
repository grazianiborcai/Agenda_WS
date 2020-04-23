package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckPhonarch extends ModelCheckerTemplateForwardV2<StoreInfo, PhonarchInfo> {
	
	public StoreCheckPhonarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PhonarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonarchCheckExist(option);
	}
	
	
	
	@Override protected PhonarchInfo toForwardClass(StoreInfo baseRecord) {
		return PhonarchCopier.copyFromStore(baseRecord);
	}
}
