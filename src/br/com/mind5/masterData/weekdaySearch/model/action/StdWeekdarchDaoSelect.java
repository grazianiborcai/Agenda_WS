package br.com.mind5.masterData.weekdaySearch.model.action;

import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdWeekdarchDaoSelect extends ActionStdTemplate<WeekdarchInfo> {

	public StdWeekdarchDaoSelect(DeciTreeOption<WeekdarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<WeekdarchInfo> buildVisitorHook(DeciTreeOption<WeekdarchInfo> option) {
		return new VisiWeekdarchDaoSelect(option);
	}
}
