package br.com.mind5.business.scheduleSearch.model.action;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedarchDaoSelect extends ActionStdTemplate<SchedarchInfo> {

	public StdSchedarchDaoSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedarchInfo> buildVisitorHook(DeciTreeOption<SchedarchInfo> option) {
		return new VisiSchedarchDaoSelect(option);
	}
}
