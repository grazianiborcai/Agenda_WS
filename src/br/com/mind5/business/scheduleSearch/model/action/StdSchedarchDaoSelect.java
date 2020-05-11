package br.com.mind5.business.scheduleSearch.model.action;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedarchDaoSelect extends ActionStdTemplateV2<SchedarchInfo> {

	public StdSchedarchDaoSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedarchInfo> buildVisitorHook(DeciTreeOption<SchedarchInfo> option) {
		return new VisiSchedarchDaoSelect(option);
	}
}
