package br.com.mind5.business.scheduleYear.model.action;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedyearEnforcePrevious extends ActionStdTemplate<SchedyearInfo> {

	public StdSchedyearEnforcePrevious(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedyearInfo> buildVisitorHook(DeciTreeOption<SchedyearInfo> option) {
		return new VisiSchedyearEnforcePrevious(option);
	}
}
