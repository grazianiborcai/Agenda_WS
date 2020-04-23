package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckAddarch extends ModelCheckerTemplateForwardV2<StoreInfo, AddarchInfo> {
	
	public StoreCheckAddarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AddarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddarchCheckExist(option);
	}
	
	
	
	@Override protected AddarchInfo toForwardClass(StoreInfo baseRecord) {
		return AddarchCopier.copyFromStoreKey(baseRecord);
	}
}
