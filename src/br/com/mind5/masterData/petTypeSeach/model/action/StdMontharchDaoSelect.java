package br.com.mind5.masterData.petTypeSeach.model.action;

import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMontharchDaoSelect extends ActionStdTemplate<MontharchInfo> {

	public StdMontharchDaoSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MontharchInfo> buildVisitorHook(DeciTreeOption<MontharchInfo> option) {
		return new VisiMontharchDaoSelect(option);
	}
}
