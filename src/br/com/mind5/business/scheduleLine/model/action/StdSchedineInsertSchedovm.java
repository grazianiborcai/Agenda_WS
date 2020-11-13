package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedineInsertSchedovm extends ActionStdTemplate<SchedineInfo> {

	public StdSchedineInsertSchedovm(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedineInfo> buildVisitorHook(DeciTreeOption<SchedineInfo> option) {
		return new VisiSchedineInsertSchedovm(option);
	}
}
