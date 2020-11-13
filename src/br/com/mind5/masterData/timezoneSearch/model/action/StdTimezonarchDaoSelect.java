package br.com.mind5.masterData.timezoneSearch.model.action;

import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdTimezonarchDaoSelect extends ActionStdTemplate<TimezonarchInfo> {

	public StdTimezonarchDaoSelect(DeciTreeOption<TimezonarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<TimezonarchInfo> buildVisitorHook(DeciTreeOption<TimezonarchInfo> option) {
		return new VisiTimezonarchDaoSelect(option);
	}
}
