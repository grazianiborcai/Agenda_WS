package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.checker.CurrencyCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoreCheckCurrency extends ModelCheckerTemplateForward<StoreInfo, CurrencyInfo> {
	
	public StoreCheckCurrency(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CurrencyInfo> getCheckerHook(ModelCheckerOption option) {
		return new CurrencyCheckExist(option);
	}
	
	
	
	@Override protected CurrencyInfo toForwardClass(StoreInfo baseRecord) {
		return CurrencyInfo.copyFrom(baseRecord);
	}
}
