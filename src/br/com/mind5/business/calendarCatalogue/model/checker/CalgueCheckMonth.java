package br.com.mind5.business.calendarCatalogue.model.checker;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.checker.MonthCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalgueCheckMonth extends ModelCheckerTemplateForward<CalgueInfo, MonthInfo> {
	
	public CalgueCheckMonth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MonthInfo> getCheckerHook(ModelCheckerOption option) {
		return new MonthCheckExist(option);
	}
	
	
	
	@Override protected MonthInfo toForwardClass(CalgueInfo baseRecord) {
		return MonthInfo.copyFrom(baseRecord);
	}
}
