package br.com.mind5.business.storeAccount.model.checker;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.checker.StoparchCheckExistStore;

public final class StoracCheckStoparch extends ModelCheckerTemplateForward<StoracInfo, StoparchInfo> {
	
	public StoracCheckStoparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoparchCheckExistStore(option);
	}
	
	
	
	@Override protected StoparchInfo toForwardClass(StoracInfo baseRecord) {
		return StoparchInfo.copyFrom(baseRecord);
	}
}
