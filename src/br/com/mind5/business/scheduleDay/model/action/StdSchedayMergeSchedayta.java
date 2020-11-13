package br.com.mind5.business.scheduleDay.model.action;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedayMergeSchedayta extends ActionStdTemplate<SchedayInfo> {

	public StdSchedayMergeSchedayta(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedayInfo> buildVisitorHook(DeciTreeOption<SchedayInfo> option) {
		return new VisiSchedayMergeSchedayta(option);
	}
}
