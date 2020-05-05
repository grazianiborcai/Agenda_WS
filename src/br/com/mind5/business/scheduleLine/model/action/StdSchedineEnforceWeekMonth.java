package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedineEnforceWeekMonth extends ActionStdTemplateV2<SchedineInfo> {

	public StdSchedineEnforceWeekMonth(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedineInfo> buildVisitorHook(DeciTreeOption<SchedineInfo> option) {
		return new VisiSchedineEnforceWeekMonth(option);
	}
}
