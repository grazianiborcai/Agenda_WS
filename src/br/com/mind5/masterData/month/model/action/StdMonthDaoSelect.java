package br.com.mind5.masterData.month.model.action;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMonthDaoSelect extends ActionStdTemplateV2<MonthInfo> {

	public StdMonthDaoSelect(DeciTreeOption<MonthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MonthInfo> buildVisitorHook(DeciTreeOption<MonthInfo> option) {
		return new VisiMonthDaoSelect(option);
	}
}
