package br.com.mind5.business.calendarCatalogue.model.checker;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.checker.MonthCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CalgueCheckMonth extends ModelCheckerTemplateForwardV2<CalgueInfo, MonthInfo> {
	
	public CalgueCheckMonth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MonthInfo> getCheckerHook(ModelCheckerOption option) {
		return new MonthCheckExist(option);
	}
	
	
	
	@Override protected MonthInfo toForwardClass(CalgueInfo baseRecord) {
		return MonthInfo.copyFrom(baseRecord);
	}
}
