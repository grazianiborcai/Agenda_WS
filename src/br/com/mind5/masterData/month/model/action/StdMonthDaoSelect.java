package br.com.mind5.masterData.month.model.action;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMonthDaoSelect extends ActionStdTemplate<MonthInfo> {

	public StdMonthDaoSelect(DeciTreeOption<MonthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MonthInfo> buildVisitorHook(DeciTreeOption<MonthInfo> option) {
		return new VisiMonthDaoSelect(option);
	}
}
