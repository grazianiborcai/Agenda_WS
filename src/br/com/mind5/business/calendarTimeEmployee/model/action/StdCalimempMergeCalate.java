package br.com.mind5.business.calendarTimeEmployee.model.action;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalimempMergeCalate extends ActionStdTemplate<CalimempInfo> {

	public StdCalimempMergeCalate(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalimempInfo> buildVisitorHook(DeciTreeOption<CalimempInfo> option) {
		return new VisiCalimempMergeCalate(option);
	}
}
