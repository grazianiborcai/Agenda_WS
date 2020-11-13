package br.com.mind5.masterData.weekday.model.action;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdWeekdayMergeWeekdarch extends ActionStdTemplate<WeekdayInfo> {

	public StdWeekdayMergeWeekdarch(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<WeekdayInfo> buildVisitorHook(DeciTreeOption<WeekdayInfo> option) {
		return new VisiWeekdayMergeWeekdarch(option);
	}
}
