package br.com.mind5.business.scheduleMonth.model.action;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdSchedmonMergeEmplis extends ActionStdTemplate<SchedmonInfo> {

	public StdSchedmonMergeEmplis(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedmonInfo> buildVisitorHook(DeciTreeOption<SchedmonInfo> option) {
		return new VisiSchedmonMergeEmplis(option);
	}
}
