package br.com.mind5.business.scheduleDay.model.action;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdSchedayMergeCalimore extends ActionStdTemplate<SchedayInfo> {

	public StdSchedayMergeCalimore(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedayInfo> buildVisitorHook(DeciTreeOption<SchedayInfo> option) {
		return new VisiSchedayMergeCalimore(option);
	}
}
