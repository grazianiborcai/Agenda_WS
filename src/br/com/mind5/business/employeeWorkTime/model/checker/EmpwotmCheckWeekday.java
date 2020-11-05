package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpwotmCheckWeekday extends ModelCheckerTemplateForwardV2<EmpwotmInfo, WeekdayInfo> {
	
	public EmpwotmCheckWeekday(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<WeekdayInfo> getCheckerHook(ModelCheckerOption option) {
		return new WeekdayCheckExist(option);
	}
	
	
	
	@Override protected WeekdayInfo toForwardClass(EmpwotmInfo baseRecord) {
		return WeekdayInfo.copyFrom(baseRecord);
	}
}
