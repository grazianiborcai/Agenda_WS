package br.com.mind5.business.store.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.model.checker.CurrencyCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class StoreCheckCurrency implements ModelChecker<StoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CurrencyInfo> checker;
	
	
	public StoreCheckCurrency(ModelCheckerOption option) {
		checker = new CurrencyCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checker.check(CurrencyInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
