package br.com.mind5.business.calendarTimeEmployee.model.action;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalimempMergeEmpwotarch extends ActionStdTemplate<CalimempInfo> {

	public StdCalimempMergeEmpwotarch(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalimempInfo> buildVisitorHook(DeciTreeOption<CalimempInfo> option) {
		return new VisiCalimempMergeEmpwotarch(option);
	}
}
