package br.com.gda.business.storeWorkTime.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.checker.WeekdayCheckExist;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreWTimeCheckWeekday implements ModelChecker<StoreWTimeInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<WeekdayInfo> checker;
	
	
	public StoreWTimeCheckWeekday(ModelCheckerOption option) {
		checker = new WeekdayCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreWTimeInfo> recordInfos) {
		for (StoreWTimeInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreWTimeInfo recordInfo) {
		return checker.check(WeekdayInfo.copyFrom(recordInfo));
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
