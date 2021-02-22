package br.com.mind5.business.materialPrice.model.checker;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class MaticeCheckWeekday extends ModelCheckerTemplateForward<MaticeInfo, WeekdayInfo> {
	
	public MaticeCheckWeekday(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<WeekdayInfo> getCheckerHook(ModelCheckerOption option) {
		return new WeekdayCheckExist(option);
	}
	
	
	
	@Override protected WeekdayInfo toForwardClass(MaticeInfo baseRecord) {
		return WeekdayInfo.copyFrom(baseRecord);
	}
}
