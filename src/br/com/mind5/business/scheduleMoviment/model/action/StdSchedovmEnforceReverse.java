package br.com.mind5.business.scheduleMoviment.model.action;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedovmEnforceReverse extends ActionStdTemplate<SchedovmInfo> {

	public StdSchedovmEnforceReverse(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedovmInfo> buildVisitorHook(DeciTreeOption<SchedovmInfo> option) {
		return new VisiSchedovmEnforceReverse(option);
	}
}
