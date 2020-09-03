package br.com.mind5.masterData.weekday.model.action;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdWeekdayMergeWeekdarch extends ActionStdTemplateV2<WeekdayInfo> {

	public StdWeekdayMergeWeekdarch(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<WeekdayInfo> buildVisitorHook(DeciTreeOption<WeekdayInfo> option) {
		return new VisiWeekdayMergeWeekdarch(option);
	}
}
