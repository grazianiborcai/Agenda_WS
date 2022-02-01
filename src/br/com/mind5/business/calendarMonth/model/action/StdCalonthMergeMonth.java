package br.com.mind5.business.calendarMonth.model.action;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdCalonthMergeMonth extends ActionStdTemplate<CalonthInfo> {

	public StdCalonthMergeMonth(DeciTreeOption<CalonthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalonthInfo> buildVisitorHook(DeciTreeOption<CalonthInfo> option) {
		return new VisiCalonthMergeMonth(option);
	}
}
