package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckExistStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class StoreCheckAddarch extends ModelCheckerTemplateForward<StoreInfo, AddarchInfo> {
	
	public StoreCheckAddarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddarchCheckExistStore(option);
	}
	
	
	
	@Override protected AddarchInfo toForwardClass(StoreInfo baseRecord) {
		return AddarchInfo.copyFrom(baseRecord);
	}
}
