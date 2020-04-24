package br.com.mind5.business.storeWorkTime.model.checker;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class StowotmCheckWeekday implements ModelCheckerV1<StowotmInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<WeekdayInfo> checker;
	
	
	public StowotmCheckWeekday(ModelCheckerOption option) {
		checker = new WeekdayCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StowotmInfo> recordInfos) {
		for (StowotmInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StowotmInfo recordInfo) {
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
