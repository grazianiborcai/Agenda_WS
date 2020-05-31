package br.com.mind5.masterData.monthSearch.model.action;

import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMontharchDaoSelect extends ActionStdTemplateV2<MontharchInfo> {

	public StdMontharchDaoSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MontharchInfo> buildVisitorHook(DeciTreeOption<MontharchInfo> option) {
		return new VisiMontharchDaoSelect(option);
	}
}
