package br.com.mind5.business.calendarMonthSearch.model.action;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalontharchDaoSelect extends ActionStdTemplate<CalontharchInfo> {

	public StdCalontharchDaoSelect(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalontharchInfo> buildVisitorHook(DeciTreeOption<CalontharchInfo> option) {
		return new VisiCalontharchDaoSelect(option);
	}
}
