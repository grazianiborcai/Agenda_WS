package br.com.mind5.masterData.weekdaySearch.model.action;

import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdWeekdarchDaoSelect extends ActionStdTemplateV2<WeekdarchInfo> {

	public StdWeekdarchDaoSelect(DeciTreeOption<WeekdarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<WeekdarchInfo> buildVisitorHook(DeciTreeOption<WeekdarchInfo> option) {
		return new VisiWeekdarchDaoSelect(option);
	}
}
