package br.com.mind5.business.scheduleRange.model.action;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedageDaoSelect extends ActionStdTemplateV2<SchedageInfo> {

	public StdSchedageDaoSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedageInfo> buildVisitorHook(DeciTreeOption<SchedageInfo> option) {
		return new VisiSchedageDaoSelect(option);
	}
}
