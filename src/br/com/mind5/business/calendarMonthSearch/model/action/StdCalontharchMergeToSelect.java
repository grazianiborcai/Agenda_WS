package br.com.mind5.business.calendarMonthSearch.model.action;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalontharchMergeToSelect extends ActionStdTemplate<CalontharchInfo> {

	public StdCalontharchMergeToSelect(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalontharchInfo> buildVisitorHook(DeciTreeOption<CalontharchInfo> option) {
		return new VisiCalontharchMergeToSelect(option);
	}
}
