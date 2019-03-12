package br.com.gda.business.storeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckExist;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreCoCheckSWT implements ModelChecker<StoreCoInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StowotmInfo> checker;
	
	
	public StoreCoCheckSWT(ModelCheckerOption option) {
		checker = new StowotmCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreCoInfo> recordInfos) {
		for (StoreCoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreCoInfo recordInfo) {
		return checker.check(StowotmInfo.copyFrom(recordInfo));
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
