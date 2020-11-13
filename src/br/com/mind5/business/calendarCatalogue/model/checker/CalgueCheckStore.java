package br.com.mind5.business.calendarCatalogue.model.checker;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalgueCheckStore extends ModelCheckerTemplateForward<CalgueInfo, StoreInfo> {
	
	public CalgueCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(CalgueInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
