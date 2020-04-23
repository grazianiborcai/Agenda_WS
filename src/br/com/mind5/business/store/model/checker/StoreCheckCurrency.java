package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.checker.CurrencyCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckCurrency extends ModelCheckerTemplateForwardV2<StoreInfo, CurrencyInfo> {
	
	public StoreCheckCurrency(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CurrencyInfo> getCheckerHook(ModelCheckerOption option) {
		return new CurrencyCheckExist(option);
	}
	
	
	
	@Override protected CurrencyInfo toForwardClass(StoreInfo baseRecord) {
		return CurrencyInfo.copyFrom(baseRecord);
	}
}
