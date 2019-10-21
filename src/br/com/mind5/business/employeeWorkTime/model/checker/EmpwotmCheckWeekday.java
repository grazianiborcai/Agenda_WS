package br.com.mind5.business.employeeWorkTime.model.checker;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmpwotmCheckWeekday implements ModelChecker<EmpwotmInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<WeekdayInfo> checker;
	
	
	public EmpwotmCheckWeekday(ModelCheckerOption option) {
		checker = new WeekdayCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpwotmInfo> recordInfos) {
		for (EmpwotmInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpwotmInfo recordInfo) {
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
