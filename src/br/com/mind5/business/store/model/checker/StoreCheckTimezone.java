package br.com.mind5.business.store.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.checker.TimezoneCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class StoreCheckTimezone implements ModelChecker<StoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<TimezoneInfo> checker;
	
	
	public StoreCheckTimezone(ModelCheckerOption option) {
		checker = new TimezoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checker.check(TimezoneInfo.copyFrom(recordInfo));
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
