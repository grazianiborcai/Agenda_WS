package br.com.mind5.masterData.timezoneSearch.model.action;

import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdTimezonarchDaoSelect extends ActionStdTemplateV2<TimezonarchInfo> {

	public StdTimezonarchDaoSelect(DeciTreeOption<TimezonarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<TimezonarchInfo> buildVisitorHook(DeciTreeOption<TimezonarchInfo> option) {
		return new VisiTimezonarchDaoSelect(option);
	}
}
